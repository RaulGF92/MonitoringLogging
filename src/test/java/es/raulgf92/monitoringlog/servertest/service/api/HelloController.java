package es.raulgf92.monitoringlog.servertest.service.api;

import org.springframework.web.bind.annotation.RestController;

import es.raulgf92.monitoringlog.servertest.service.api.dto.RequestHelloDto;
import es.raulgf92.monitoringlog.servertest.service.api.dto.ResponseHelloDto;

@RestController
public interface HelloController {

	ResponseHelloDto sayHello(RequestHelloDto request);

}
