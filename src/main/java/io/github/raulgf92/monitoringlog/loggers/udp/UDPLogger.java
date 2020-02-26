package io.github.raulgf92.monitoringlog.loggers.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.raulgf92.monitoringlog.MonitorLogger;
import io.github.raulgf92.monitoringlog.model.FunctionInfo;


public class UDPLogger implements MonitorLogger {
	
	UDPConfiguration configuration;
	private DatagramSocket socket;
	private InetAddress address;

	Logger logger = LoggerFactory.getLogger(UDPLogger.class);
	private BiFunction<FunctionInfo, MonitorLoggerState, String> parser;

	public UDPLogger(UDPConfiguration configuration) throws SocketException, UnknownHostException {
		this.configuration = configuration;
		socket = new DatagramSocket();
		address = InetAddress.getByName(configuration.getUrl());
		logger.info(String.format("The UDPLogger was load correct, the packets will send it to udp:%s:%d",
				configuration.getUrl(), configuration.getPort()));
	}

	protected void sendInfo(byte[] buf) throws IOException {
		DatagramPacket packet = new DatagramPacket(buf, buf.length, this.address, configuration.getPort().intValue());
		socket.send(packet);
	}


	@Override
	public void printStart(FunctionInfo info) {
		String infoParse = this.parser != null? this.parser.apply(info, MonitorLoggerState.START): this.functionInfoToJsonString(info);
		try {
			this.sendInfo(infoParse.getBytes());
		} catch (IOException e) {
			logger.info("Was happend a error send it UDP packet", e);
		}
	}


	@Override
	public void printFinal(FunctionInfo info) {
		String infoParse = this.parser != null? this.parser.apply(info, MonitorLoggerState.FINAL): this.functionInfoToJsonString(info);
		try {
			this.sendInfo(infoParse.getBytes());
		} catch (IOException e) {
			logger.info("Was happend a error send it UDP packet", e);
		}
	}


	@Override
	public void printError(FunctionInfo info) {
		String infoParse = this.parser != null? this.parser.apply(info, MonitorLoggerState.ERROR): this.functionInfoToJsonString(info);
		try {
			this.sendInfo(infoParse.getBytes());
		} catch (IOException e) {
			logger.info("Was happend a error send it UDP packet", e);
		}
	}

	/* GETTERS & SETTERS */
	
	public BiFunction<FunctionInfo, MonitorLoggerState, String> getParser() {
		return parser;
	}

	public void setParser(BiFunction<FunctionInfo, MonitorLoggerState, String> parser) {
		this.parser = parser;
	}
}
