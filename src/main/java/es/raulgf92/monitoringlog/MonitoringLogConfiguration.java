package es.raulgf92.monitoringlog;

import java.util.ArrayList;
import java.util.List;

import es.raulgf92.monitoringlog.loggers.SystemLogger;

public class MonitoringLogConfiguration {

	private List<MonitorLogger> monitors;
	private Integer numberThread = 5;
	private Long maxTimeSleep = 5 * 60 * 1000L; // 5 min

	public MonitorLogger[] getMonitorsAsArray() {
		return monitors.toArray(new MonitorLogger[monitors.size()]);
	}
	
	public List<MonitorLogger> getMonitors() {
		return monitors;
	}

	public void setMonitors(List<MonitorLogger> monitors) {
		this.monitors = monitors;
	}

	public Integer getNumberThread() {
		return numberThread;
	}

	public void setNumberThread(Integer numberThread) {
		this.numberThread = numberThread;
	}

	public Long getMaxTimeSleep() {
		return maxTimeSleep;
	}

	public void setMaxTimeSleep(Long maxTimeSleep) {
		this.maxTimeSleep = maxTimeSleep;
	}
	
	
	public static class Builder {

		private List<MonitorLogger> monitors;
		private int numberThread = 5;
		private Long maxTimeSleep = 5 * 60 * 1000L; // 5 mins

		public Builder() {
			this.monitors = new ArrayList<MonitorLogger>();
			this.monitors.add(new SystemLogger());
		}

		public MonitoringLogConfiguration build() {
			MonitoringLogConfiguration response = new MonitoringLogConfiguration();
			response.setMonitors(this.monitors);
			response.setNumberThread(this.numberThread);
			response.setMaxTimeSleep(this.maxTimeSleep);
			return response;
		}

		public Builder addMonitor(MonitorLogger logger) {
			this.monitors.add(logger);
			return this;
		}

		public int getNumberThread() {
			return numberThread;
		}

		public Builder setNumberThread(int numberThread) {
			this.numberThread = numberThread;
			return this;
		}

		public Long getMaxTimeSleep() {
			return maxTimeSleep;
		}

		public Builder setMaxTimeSleep(Long maxTimeSleep) {
			this.maxTimeSleep = maxTimeSleep;
			return this;
		}
	}
}
