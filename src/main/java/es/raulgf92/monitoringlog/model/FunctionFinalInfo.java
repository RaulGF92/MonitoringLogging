package es.raulgf92.monitoringlog.model;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;

public class FunctionFinalInfo extends FunctionInfo {

	public FunctionFinalInfo(String identificator, Date date, ProceedingJoinPoint joinPoint, Object response) {
		super(FunctionInfo.FunctionInfoState.FINAL, identificator, date, joinPoint, response);
	}

}
