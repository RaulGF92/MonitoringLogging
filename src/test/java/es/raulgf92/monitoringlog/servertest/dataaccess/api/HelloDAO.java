package es.raulgf92.monitoringlog.servertest.dataaccess.api;

import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import es.raulgf92.monitoringlog.servertest.DAOException;
import es.raulgf92.monitoringlog.servertest.dataaccess.api.entities.UserEntity;


@Repository
public interface HelloDAO {

	UserEntity getHelloByEmail(String email) throws DAOException;

}
