package es.raulgf92.monitoringlog.loggers.monitoringlogui;

import es.raulgf92.monitoringlog.loggers.udp.UDPConfiguration;

public class MonitoringLogUIConfiguration extends UDPConfiguration {

	public String applicationName;

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	
}
