package es.raulgf92.monitoringlog.loggers.udp;

import java.net.Proxy;

public class UDPConfiguration {

	private String url;
	private Integer port;
	private Proxy poxy;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public Proxy getPoxy() {
		return poxy;
	}

	public void setPoxy(Proxy poxy) {
		this.poxy = poxy;
	}
}
