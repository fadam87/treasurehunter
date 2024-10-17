package pti.sb_treasurehunter_rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pti.sb_treasurehunter_rest.db.Database;
import pti.sb_treasurehunter_rest.dto.ResponseDTO;
import pti.sb_treasurehunter_rest.dto.RestData;
import pti.sb_treasurehunter_rest.dto.UserDto;
import pti.sb_treasurehunter_rest.model.User;

@Service
public class AppService {

	private Database db;
	
	
	@Autowired
	public AppService(Database db) {
		super();
		this.db = db;
	}


	public ResponseDTO doLogin(String userName, String userPwd) {

		
		ResponseDTO responseDto = new ResponseDTO();
		
		User user = db.getUserByNameAndPassword(userName, userPwd);
		if(user != null) {
			responseDto.setSucces(true);
			UserDto userDto =  new UserDto(
						user.getId(),
						user.getName(),
						user.getLifes(),
						user.getRecordSteps()
					);
			responseDto.setUserDto(userDto);
		}
		
		
		return responseDto;
	}


	public ResponseDTO saveUser(int userId, int lifes, int steps) {


		User user = db.getUserById(userId);
		
		
		
		UserDto userDto = new UserDto(user.getId(), user.getName(), lifes, user.getRecordSteps() );
		
		if(user.getRecordSteps() > steps && lifes > 0) {
			
			userDto.setRecordSteps(steps);
			user.setRecordSteps(steps);
			
		}
		
		if (lifes >= 0) {
			user.setLifes(lifes);
		}
		
		else {
			
			user.setLifes(0);
		}
		
		db.saveUser(user);
		
		ResponseDTO responseDto = new ResponseDTO();
		responseDto.setSucces(true);
		responseDto.setUserDto(userDto);
		
		return responseDto;
	}




	public void saveUserLife(RestData userData) {

		User user = null;
		
		user = db.getUserById(userData.getUid());
		
		if(user != null) {
			
			user.setLifes(userData.getLife());
			
			db.saveUser(user);
			
		}
		
		
	}

}

























