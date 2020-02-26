package io.github.raulgf92.monitoringlog.interceptors.thread;

import java.util.concurrent.ConcurrentLinkedQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.raulgf92.monitoringlog.MonitorLogger;
import io.github.raulgf92.monitoringlog.model.FunctionInfo;



public class ThreadHandler extends Thread {

	Logger logger = LoggerFactory.getLogger(ThreadHandler.class);

	private MonitorLogger[] loggers;
	private ConcurrentLinkedQueue<FunctionInfo> dataCache;
	private Long sleepTime = 0L;
	private Long maxTimeSleeping;
	private String threadId;

	public ThreadHandler(String threadId, MonitorLogger[] loggers, ConcurrentLinkedQueue<FunctionInfo> dataCache,
			Long maxTimeSleeping) {
		this.loggers = loggers;
		this.dataCache = dataCache;
		this.threadId = threadId;
		this.maxTimeSleeping = maxTimeSleeping;
	}

	public void run() {
		while (true) {
			FunctionInfo info = this.dataCache.poll();

			if (info == null) {
				this.sleepAndIncrease();
			} else {
				this.sleepTime = 0L;
				this.printOnAllLoggers(info);
			}

		}
	}

	@SuppressWarnings("static-access")
	private void sleepAndIncrease() {

		if (this.sleepTime == 0) {
			this.sleepTime = 100L;
		} else if (this.sleepTime < this.maxTimeSleeping) {
			this.sleepTime = this.sleepTime * 2 + this.getRandomIncrease();
		}

		try {
			this.sleep(this.sleepTime);
		} catch (InterruptedException e) {
			logger.info(String.format("%s can't sleep and still awake on cycle more", this.threadId));
		}
	}

	private long getRandomIncrease() {
		long response;
		Double randomNumber = Math.random() * 10;
		response = randomNumber.longValue();

		if (Math.random() < 0.5) {
			response = response * -1;
		}

		return response;
	}

	private void printOnAllLoggers(FunctionInfo info) {
		for (MonitorLogger monitorsLogger : loggers) {
			if (info.getError() != null) {
				monitorsLogger.printError(info);
			} else if(info.getResponse() != null) {
				monitorsLogger.printFinal(info);
			} else {
				monitorsLogger.printStart(info);
			}
		}
	}

}
