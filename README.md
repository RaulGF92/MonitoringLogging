# Monitoring Logger

Monitoring Logger es una libreria JDK8 que apoya en la trazabilidad de las aplicaciones Spring boot utilizando anotaciones y programación orientada a aspectos.

## Como usuar

1. *Deberas introducir la libreria importandola con el jar* o puedes mirar los diferentes tipos de importación permitidos 

2. Inicializar configurador

   ```java
   @MonitoringLogging //Init MonitoringLogging Library
   @SpringBootApplication
   public class Application {
   	
       public static void main(String[] args) {
           SpringApplication.run(Application.class, args);
       }
       
       @Bean
       public MonitoringLogConfiguration getMonitoringLogConfiguration() {
       	
           //All messages will send it to upd://localhost:13137
       	UDPLogger udpLogger = new UDPLoggerBuilder()
       			.setPort(13137)
       			.build();
       	
       	//see more WebSocketLogger...
       	
   		return new MonitoringLogConfiguration.Builder()
   				.setNumberThread(5)
   				.setMaxTimeSleep(300000L) // 5mins
   				.addMonitor(udpLogger)
               	//add More ...
   				.build();
       }
       
   }
   ```

   

3. Añadir a la clase seleccionada

```java
@RestController
@Logged //Linked all methods to MonitoringLogging Library
public class HelloControllerImpl implements HelloController {
	
	@RequestMapping(value = "/sayHello", method = RequestMethod.POST)
	public String sayHello(@RequestBody String request) {
		return "Hola";
	}
}
```



4. Comprobar resultado

## Filosofia de uso

Monitoring Logger se originó pensando en ser un soporte para la trazabilidad de arquitecturas de N-Capas puediendo extraer información vital y a tiempo real de las distintas capas del sistema con intención de realizar mejoras proactivas en función de los resultados extraidos.Esta libreria no es un recambio a la colocación de loggers o impresión, es mas *se recomienda el uso intensivo y paralelo a ello*.

```bash
              			 ------------------------
             			| @Logged                |
                        |        Service         |
                        |                        |
                         ------------------------
                         ------------------------
                        | @Logged                |
                        |     Bussiness - 1      |
                        |                        |
                         ------------------------
                         ------------------------
                        | @Logged                |
                        |     Bussiness - N      |
                        |                        |
                         ------------------------
                         ------------------------
                        | @Logged                |
                        |       DAO - N          |
                        |                        |
                         ------------------------
```



