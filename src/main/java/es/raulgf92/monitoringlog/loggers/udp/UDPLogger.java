package es.raulgf92.monitoringlog.loggers.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.raulgf92.monitoringlog.MonitorLogger;
import es.raulgf92.monitoringlog.model.FunctionInfo;


public class UDPLogger implements MonitorLogger {
	
	UDPConfiguration configuration;
	private DatagramSocket socket;
	private InetAddress address;

	Logger logger = LoggerFactory.getLogger(UDPLogger.class);

	public UDPLogger(UDPConfiguration configuration) throws SocketException, UnknownHostException {
		this.configuration = configuration;
		socket = new DatagramSocket();
		address = InetAddress.getByName(configuration.getUrl());
		logger.info(String.format("The UDPLogger was load correct, the packets will send it to udp:%s:%d",
				configuration.getUrl(), configuration.getPort()));
	}

	@Override
	public void printInfo(FunctionInfo info) {
		this.printInfo(info, (FunctionInfo parameter) -> this.functionInfoToJsonString(info));
	}

	@Override
	public void printError(FunctionInfo info) {
		this.printError(info, (FunctionInfo parameter) -> this.functionInfoToJsonString(info));
	}

	@Override
	public void printInfo(FunctionInfo info, Function<FunctionInfo, String> parser) {
		String infoParse = parser.apply(info);
		try {
			this.sendInfo(infoParse.getBytes());
		} catch (IOException e) {
			logger.info("Was happend a error send it UDP packet", e);
		}
	}

	@Override
	public void printError(FunctionInfo info, Function<FunctionInfo, String> parser) {
		String infoParse = parser.apply(info);
		try {
			this.sendInfo(infoParse.getBytes());
		} catch (IOException e) {
			logger.info("Was happend a error send it UDP packet", e);
		}
	}

	private void sendInfo(byte[] buf) throws IOException {
		DatagramPacket packet = new DatagramPacket(buf, buf.length, this.address, configuration.getPort().intValue());
		socket.send(packet);
	}

}
