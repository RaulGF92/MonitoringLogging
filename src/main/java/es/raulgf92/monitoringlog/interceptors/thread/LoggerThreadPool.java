package es.raulgf92.monitoringlog.interceptors.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import es.raulgf92.monitoringlog.MonitorLogger;
import es.raulgf92.monitoringlog.model.FunctionInfo;

public class LoggerThreadPool {

	private int numberThread;
	private MonitorLogger[] loggers;
	private ConcurrentLinkedQueue<FunctionInfo> dataCache;
	private List<ThreadHandler> threads;
	private Long maxTimeSleep;

	public LoggerThreadPool(int numberThread,Long maxTimeSleep, MonitorLogger[] loggers, ConcurrentLinkedQueue<FunctionInfo> cache) {
		this.numberThread = numberThread;
		this.loggers = loggers;
		this.dataCache = cache;
		this.threads = new ArrayList<ThreadHandler>();
		this.maxTimeSleep = maxTimeSleep;
		this.loadThreads();
	}

	private void loadThreads() {
		for (int i = 0; i < numberThread; i++) {
			String id = String.format("Thread-[%s]", i);
			ThreadHandler threadHandler = new ThreadHandler(id, loggers, dataCache, maxTimeSleep);
			threadHandler.start();
			threads.add(threadHandler);
		}
	}
}
