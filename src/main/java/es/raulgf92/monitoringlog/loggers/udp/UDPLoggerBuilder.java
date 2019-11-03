package es.raulgf92.monitoringlog.loggers.udp;

import java.net.Proxy;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPLoggerBuilder {

	private String url = "localhost";
	private Integer port = 13137;
	private Proxy proxy = null;

	public UDPLogger build() {
		UDPConfiguration configuration = new UDPConfiguration();
		configuration.setPort(this.port);
		configuration.setPoxy(this.proxy);
		configuration.setUrl(this.url);
		
		UDPLogger response;
		try {
			response = new UDPLogger(configuration);
		} catch (SocketException | UnknownHostException e) {
			throw new RuntimeException(e);
		}
		return response;
	}

	public String getUrl() {
		return url;
	}

	public UDPLoggerBuilder setUrl(String url) {
		this.url = url;
		return this;
	}

	public Integer getPort() {
		return port;
	}

	public UDPLoggerBuilder setPort(Integer port) {
		this.port = port;
		return this;
	}

	public Proxy getPoxy() {
		return proxy;
	}

	public UDPLoggerBuilder setPoxy(Proxy poxy) {
		this.proxy = poxy;
		return this;
	}
	
}
