package io.github.raulgf92.monitoringlog.loggers.lucalog;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.UUID;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.raulgf92.monitoringlog.loggers.udp.UDPLogger;
import io.github.raulgf92.monitoringlog.model.FunctionInfo;

public class LucaLogLogger extends UDPLogger {

	Logger logger = LoggerFactory.getLogger(LucaLogLogger.class);
	private String applicationIdentificator;
	
	public LucaLogLogger(LucaLogConfiguration configuration) throws SocketException, UnknownHostException {
		super(configuration);
		this.applicationIdentificator = this.generateApplicationIdentificator(configuration.applicationName);
		logger.info("------------------------------------------------------------------------------------------------------");
		logger.info("The LucaLog-Logger was created, the application was loaded with name " + applicationIdentificator);
		logger.info("Put applicationIdentificator on LucaLog for show responses on real time");
		logger.info("------------------------------------------------------------------------------------------------------");
		
	}

	public static LucaLogBuilder builder() {
		return new LucaLogBuilder();
	}
	
	@Override
	public void printInfo(FunctionInfo info) {
		FunctionInfoUI _info = new FunctionInfoUI(info);
		_info.setApplicationName(this.applicationIdentificator);
		String infoParse = this.functionInfoToJsonString(_info);
		
		try {
			super.sendInfo(infoParse.getBytes());
		} catch (IOException e) {
			logger.info("Was happend a error send it UDP packet", e);
		}
	}

	@Override
	public void printError(FunctionInfo info) {
		FunctionInfoUI _info = new FunctionInfoUI(info);
		_info.setApplicationName(this.applicationIdentificator);
		String infoParse = this.functionInfoToJsonString(_info);
		try {
			super.sendInfo(infoParse.getBytes());
		} catch (IOException e) {
			logger.info("Was happend a error send it UDP packet", e);
		}
	}

	
	/**
	 * Sobrescribimos la función printInfo para añadirle el nombre de aplicación
	 */
	@Override
	public void printInfo(FunctionInfo info, Function<FunctionInfo, String> parser) {
		throw new RuntimeException("Not Implemented");
	}

	/**
	 * Sobrescribimos la función printInfo para añadirle el nombre de aplicación
	 */
	@Override
	public void printError(FunctionInfo info, Function<FunctionInfo, String> parser) {
		throw new RuntimeException("Not Implemented");
	}
	
	private String generateApplicationIdentificator(String applicationName) {
		UUID uuid = UUID.randomUUID();
		return String.format("%s__#%s#",applicationName, uuid.toString());
	}


}
