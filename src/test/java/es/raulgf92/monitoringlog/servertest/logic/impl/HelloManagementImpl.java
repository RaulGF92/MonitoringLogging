package es.raulgf92.monitoringlog.servertest.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.raulgf92.monitoringlog.annotations.MonotoringLog;
import es.raulgf92.monitoringlog.servertest.DAOException;
import es.raulgf92.monitoringlog.servertest.dataaccess.api.HelloDAO;
import es.raulgf92.monitoringlog.servertest.dataaccess.api.entities.UserEntity;
import es.raulgf92.monitoringlog.servertest.logic.api.HelloManagement;
import es.raulgf92.monitoringlog.servertest.logic.api.model.User;
import es.raulgf92.monitoringlog.servertest.service.api.dto.RequestHelloDto;

@Component("HelloManagement")
@MonotoringLog
public class HelloManagementImpl implements HelloManagement {

	@Autowired
	HelloDAO helloDAO;
	
	public User handleHello(RequestHelloDto requestHelloDto) throws DAOException {
		UserEntity entity = helloDAO.getHelloByEmail(requestHelloDto.getEmail());
		User user = this.parseEntityToModel(entity);
		return user;
	}

	private User parseEntityToModel(UserEntity entity) {
		User response = new User();
		response.setEmail(entity.getEmail());
		response.setName(entity.getName());
		return response;
	}

}
