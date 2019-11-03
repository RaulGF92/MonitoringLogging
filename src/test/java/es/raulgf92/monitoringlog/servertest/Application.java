package es.raulgf92.monitoringlog.servertest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import es.raulgf92.monitoringlog.MonitoringLogConfiguration;
import es.raulgf92.monitoringlog.loggers.udp.UDPLogger;
import es.raulgf92.monitoringlog.loggers.udp.UDPLoggerBuilder;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public MonitoringLogConfiguration getMonitoringLogConfiguration() {
    	
    	UDPLogger udpLogger = new UDPLoggerBuilder()
    			.setPort(13137)
    			.build();
    	
    	//see more WebSocketLogger...
    	
		return new MonitoringLogConfiguration.Builder()
				.setNumberThread(5)
				.setMaxTimeSleep(300000L) // 5mins
				.addMonitor(udpLogger)
				.build();
    }
    
}