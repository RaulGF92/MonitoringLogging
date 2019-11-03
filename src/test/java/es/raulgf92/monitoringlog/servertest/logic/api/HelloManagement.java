package es.raulgf92.monitoringlog.servertest.logic.api;

import org.springframework.stereotype.Service;

import es.raulgf92.monitoringlog.servertest.DAOException;
import es.raulgf92.monitoringlog.servertest.logic.api.model.User;
import es.raulgf92.monitoringlog.servertest.service.api.dto.RequestHelloDto;


@Service
public interface HelloManagement {

	User handleHello(RequestHelloDto requestHelloDto) throws DAOException;

}
