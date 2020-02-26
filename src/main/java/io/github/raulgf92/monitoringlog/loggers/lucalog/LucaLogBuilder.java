package io.github.raulgf92.monitoringlog.loggers.lucalog;

import java.net.Proxy;
import java.net.SocketException;
import java.net.UnknownHostException;

public class LucaLogBuilder {

		private String url = "localhost";
		private Integer port = 13137;
		private Proxy proxy = null;
		private String applicationName ="LucaLog-DefaultApp";

		public LucaLogLogger build() throws SocketException, UnknownHostException {
			LucaLogConfiguration configuration = new LucaLogConfiguration();
			configuration.setPort(this.port);
			configuration.setPoxy(this.proxy);
			configuration.setUrl(this.url);
			configuration.setApplicationName(this.applicationName);
			return new LucaLogLogger(configuration);
		}

		public String getUrl() {
			return url;
		}

		public LucaLogBuilder setUrl(String url) {
			this.url = url;
			return this;
		}

		public Integer getPort() {
			return port;
		}

		public LucaLogBuilder setPort(Integer port) {
			this.port = port;
			return this;
		}

		public Proxy getProxy() {
			return proxy;
		}

		public LucaLogBuilder setProxy(Proxy proxy) {
			this.proxy = proxy;
			return this;
		}

		public String getApplicationName() {
			return applicationName;
		}

		public LucaLogBuilder setApplicationName(String applicationName) {
			this.applicationName = applicationName;
			return this;
		}
}
