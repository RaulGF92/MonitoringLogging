package es.raulgf92.monitoringlog.loggers.monitoringlogui;

import java.net.Proxy;
import java.net.SocketException;
import java.net.UnknownHostException;

public class MonitoringLogUIBuilder {

		private String url = "localhost";
		private Integer port = 13137;
		private Proxy proxy = null;
		private String applicationName ="Monitoring-Default";

		public MonitoringLogUILogger build() throws SocketException, UnknownHostException {
			MonitoringLogUIConfiguration configuration = new MonitoringLogUIConfiguration();
			configuration.setPort(this.port);
			configuration.setPoxy(this.proxy);
			configuration.setUrl(this.url);
			configuration.setApplicationName(this.applicationName);
			return new MonitoringLogUILogger(configuration);
		}

		public String getUrl() {
			return url;
		}

		public MonitoringLogUIBuilder setUrl(String url) {
			this.url = url;
			return this;
		}

		public Integer getPort() {
			return port;
		}

		public MonitoringLogUIBuilder setPort(Integer port) {
			this.port = port;
			return this;
		}

		public Proxy getProxy() {
			return proxy;
		}

		public MonitoringLogUIBuilder setProxy(Proxy proxy) {
			this.proxy = proxy;
			return this;
		}

		public String getApplicationName() {
			return applicationName;
		}

		public MonitoringLogUIBuilder setApplicationName(String applicationName) {
			this.applicationName = applicationName;
			return this;
		}
}
