package io.github.raulgf92.monitoringlog.loggers;

import java.util.function.BiFunction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.raulgf92.monitoringlog.MonitorLogger;
import io.github.raulgf92.monitoringlog.model.FunctionInfo;

public class SystemLogger implements MonitorLogger {

	Logger logger = LoggerFactory.getLogger(SystemLogger.class);
	
	private BiFunction<FunctionInfo,MonitorLoggerState, String> parserToMsg;
	
	public enum SystemLoggerLevel {
		DEBUG, INFO, ERROR
	}
	
	private SystemLoggerLevel startLogLevel = SystemLoggerLevel.INFO;
	private SystemLoggerLevel finalLogLevel = SystemLoggerLevel.INFO;
	private SystemLoggerLevel errorLogLevel = SystemLoggerLevel.ERROR;
	
	@Override
	public void printStart(FunctionInfo info) {
		String infoParse = this.parserToMsg != null? this.parserToMsg.apply(info, MonitorLoggerState.START): this.functionInfoToJsonString(info);
		this.printInfo(infoParse, this.startLogLevel);
	}


	@Override
	public void printFinal(FunctionInfo info) {
		String infoParse = this.parserToMsg != null? this.parserToMsg.apply(info, MonitorLoggerState.FINAL): this.functionInfoToJsonString(info);
		this.printInfo(infoParse, this.finalLogLevel);
	}
	
	@Override
	public void printError(FunctionInfo info) {
		String infoParse = this.parserToMsg != null? this.parserToMsg.apply(info, MonitorLoggerState.FINAL): this.functionInfoToJsonString(info);
		this.printInfo(infoParse, this.errorLogLevel);
	}
	
	/*	FUNCIONES AUXILIARES */
	
	private void printInfo(String infoParse, SystemLoggerLevel logLevel) {
		if(SystemLoggerLevel.INFO.equals(logLevel)) {
			logger.info(infoParse);
		}
		
		if(SystemLoggerLevel.ERROR.equals(logLevel)) {
			logger.error(infoParse);
		}
		
		if(SystemLoggerLevel.DEBUG.equals(logLevel)) {
			logger.debug(infoParse);
		}
	}

	/*	GETTERS & SETTERS */
	
	public BiFunction<FunctionInfo,MonitorLoggerState, String> getParserToMsg() {
		return this.parserToMsg;
	}

	public void setParserToMsg(BiFunction<FunctionInfo,MonitorLoggerState, String> parserToMsg) {
		this.parserToMsg = parserToMsg;
	}


	public SystemLoggerLevel getStartLogLevel() {
		return startLogLevel;
	}


	public void setStartLogLevel(SystemLoggerLevel startLogLevel) {
		this.startLogLevel = startLogLevel;
	}


	public SystemLoggerLevel getFinalLogLevel() {
		return finalLogLevel;
	}


	public void setFinalLogLevel(SystemLoggerLevel finalLogLevel) {
		this.finalLogLevel = finalLogLevel;
	}


	public SystemLoggerLevel getErrorLogLevel() {
		return errorLogLevel;
	}


	public void setErrorLogLevel(SystemLoggerLevel errorLogLevel) {
		this.errorLogLevel = errorLogLevel;
	}

}
