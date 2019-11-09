package es.raulgf92.monitoringlog.servertest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.raulgf92.monitoringlog.annotations.Logged;
import es.raulgf92.monitoringlog.annotations.monitoringlogui.MonitoringLogUI;
import es.raulgf92.monitoringlog.annotations.monitoringlogui.SoftwareLayer;
import es.raulgf92.monitoringlog.servertest.DAOException;
import es.raulgf92.monitoringlog.servertest.logic.api.HelloManagement;
import es.raulgf92.monitoringlog.servertest.logic.api.model.User;
import es.raulgf92.monitoringlog.servertest.service.api.HelloController;
import es.raulgf92.monitoringlog.servertest.service.api.dto.RequestHelloDto;
import es.raulgf92.monitoringlog.servertest.service.api.dto.ResponseHelloDto;

@Component("HelloController")
@Logged
public class HelloControllerImpl implements HelloController {

	@Autowired
	HelloManagement helloManagement;
	
	@RequestMapping(value = "/sayHello", method = RequestMethod.POST)
	public ResponseHelloDto sayHello(@RequestBody RequestHelloDto request) {
		ResponseHelloDto response = new ResponseHelloDto();
		try {
			User user = helloManagement.handleHello(request);
			response.setMessage("Hola " + user.getName());
		} catch (DAOException e) {
			response.setMessage(e.getMessage());
		}
		
		return response;
	}
}
