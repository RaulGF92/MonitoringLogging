package es.raulgf92.monitoringlog.interceptors;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.annotation.PostConstruct;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import es.raulgf92.monitoringlog.MonitoringLogConfiguration;
import es.raulgf92.monitoringlog.interceptors.thread.LoggerThreadPool;
import es.raulgf92.monitoringlog.model.FunctionInfo;

@Aspect
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Configuration
public class MethodInterceptorLog {
	
	@Autowired
	private MonitoringLogConfiguration configuration;
	private ConcurrentLinkedQueue<FunctionInfo> cache;
	
	@SuppressWarnings("unused")
	private LoggerThreadPool pool;
	
	@PostConstruct
	public void init() {
		//TODO: Hacer esto por configuración
		this.cache = new ConcurrentLinkedQueue<FunctionInfo>();
		this.pool = new LoggerThreadPool(
				configuration.getNumberThread(), 
				configuration.getMaxTimeSleep(),
				configuration.getMonitorsAsArray(), 
				cache);
	}
	
	// TODO: CAMBIAR EL PATH PARA CUANDO TENGA UNO FIJO
	@Around("execution(public * ((@es.capgmeni.pruebas.monotoringlog.annotations.MonotoringLog *)+).*(..))")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		Object response = null;
		String identificator = this.getUniqueIdentificator();
		this.handleBegan(identificator, joinPoint);

		try {
			response = joinPoint.proceed();
		} catch (Exception e) {
			this.handleException(identificator, joinPoint, e);
			throw e;
		}

		this.handleEnd(identificator, joinPoint, response);
		return response;
	}

	/**
	 * TODO: En vez de crear N hilos por cada llamada a una función (realmente
	 * ineficiente) habría que crear N hilos que atacará a un buffer común y que ya
	 * esten ejecutados siempre
	 */

	/**
	 * 
	 * @param identificator
	 * @param joinPoint
	 */
	private void handleBegan(String identificator, ProceedingJoinPoint joinPoint) {
		FunctionInfo info = new FunctionInfo(identificator, new Date(), joinPoint);
		this.cache.add(info);
	}

	private void handleEnd(String identificator, ProceedingJoinPoint joinPoint, Object response) {
		FunctionInfo info = new FunctionInfo(identificator, new Date(), joinPoint, response);
		this.cache.add(info);

	}

	private void handleException(String identificator, ProceedingJoinPoint joinPoint, Exception e) {
		FunctionInfo info = new FunctionInfo(identificator, new Date(), joinPoint, e);
		this.cache.add(info);

	}

	private String getUniqueIdentificator() {
		return UUID.randomUUID().toString();
	}
}
