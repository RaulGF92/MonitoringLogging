package es.raulgf92.monitoringlog.servertest.dataaccess.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import es.raulgf92.monitoringlog.annotations.MonotoringLog;
import es.raulgf92.monitoringlog.servertest.DAOException;
import es.raulgf92.monitoringlog.servertest.dataaccess.api.HelloDAO;
import es.raulgf92.monitoringlog.servertest.dataaccess.api.entities.UserEntity;


@Component("HelloDAO")
@MonotoringLog
public class HelloDAOImpl implements HelloDAO {

	ArrayList<UserEntity> users;
	
	@PostConstruct
	public void init() {
		users = new ArrayList<UserEntity>();
		
		UserEntity raul = new UserEntity();
		raul.setEmail("raulgf92@gmail.com");
		raul.setName("Raúl");
		raul.setId(Long.parseLong("12312"));
		users.add(raul);
		
		UserEntity jose = new UserEntity();
		jose.setEmail("jose@gmail.com");
		jose.setName("Jose");
		jose.setId(Long.parseLong("12453312"));
		users.add(jose);
		
		UserEntity edu = new UserEntity();
		edu.setEmail("edu@gmail.com");
		edu.setName("Edu");
		edu.setId(Long.parseLong("12342335"));
		users.add(edu);
		
		users.add(edu);
	}
	
	@Override
	public UserEntity getHelloByEmail(String email) throws DAOException {
		for (UserEntity userEntity : users) {
			if(userEntity.getEmail().equals(email)) {
				return userEntity;
			}
		}
		
		throw new DAOException("No hay usuarios con ese email");
	}


}
