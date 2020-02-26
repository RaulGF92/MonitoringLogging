package io.github.raulgf92.monitoringlog.loggers;

import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.raulgf92.monitoringlog.MonitorLogger;
import io.github.raulgf92.monitoringlog.model.FunctionInfo;

public class SystemLogger implements MonitorLogger {

	Logger logger = LoggerFactory.getLogger(SystemLogger.class);
	
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
		logger.info(infoParse);
	}

	@Override
	public void printError(FunctionInfo info, Function<FunctionInfo, String> parser) {
		String infoParse = parser.apply(info);
		logger.info(infoParse);
	}

}
