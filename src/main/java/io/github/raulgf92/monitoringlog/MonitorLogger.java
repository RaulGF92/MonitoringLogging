package io.github.raulgf92.monitoringlog;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.raulgf92.monitoringlog.model.FunctionInfo;


public interface MonitorLogger {

	public enum MonitorLoggerState {
		START,FINAL,ERROR
	}
	
	void printStart(FunctionInfo info);

	void printFinal(FunctionInfo info);
	
	void printError(FunctionInfo info);
	
    default String functionInfoToJsonString(FunctionInfo info) 
    { 
		String response;
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			response = objectMapper.writeValueAsString(info);
		} catch (JsonProcessingException e) {
			response = e.getMessage();
		}	
		
		return response;
    } 
}
