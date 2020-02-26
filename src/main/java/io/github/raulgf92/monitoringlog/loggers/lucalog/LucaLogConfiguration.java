package io.github.raulgf92.monitoringlog.loggers.lucalog;

import io.github.raulgf92.monitoringlog.loggers.udp.UDPConfiguration;

public class LucaLogConfiguration extends UDPConfiguration {

	public String applicationName;

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	
}
