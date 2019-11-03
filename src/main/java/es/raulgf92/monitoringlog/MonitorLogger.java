package es.raulgf92.monitoringlog;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.raulgf92.monitoringlog.model.FunctionInfo;

public interface MonitorLogger {

	void printInfo(FunctionInfo info);

	void printError(FunctionInfo info);

	void printInfo(FunctionInfo info, Function<FunctionInfo, String> parser);

	void printError(FunctionInfo info, Function<FunctionInfo, String> parser);

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
