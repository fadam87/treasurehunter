package pti.sb_treasurehunter_rest.controller;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pti.sb_treasurehunter_rest.dto.ResponseDTO;

import pti.sb_treasurehunter_rest.service.AppService;

@RestController
@CrossOrigin("http://localhost:4200/")
public class AppController {

private AppService service;
	
	
	@Autowired
	public AppController(AppService service) {
		super();
		this.service = service;
	}

	@PostMapping("/game")
	public ResponseDTO login(
				Model model,
				@RequestParam("uname") String userName,
				@RequestParam("upwd") String userPwd
			) {
		
		System.out.println(userName);
		System.out.println(userPwd);
		
		ResponseDTO responseDto = service.doLogin(userName, userPwd);
		

		return responseDto;
	}
		

	@PostMapping("/game/save")
	public ResponseDTO saveUser(
							Model model,
							@RequestParam("id") int userId,
							@RequestParam("lifes") int lifes,
							@RequestParam("steps") int steps	
							){
		
		
		ResponseDTO responseDto = service.saveUser(userId, lifes, steps);
		
		System.out.println(userId);
		System.out.println(lifes);
		System.out.println(steps);
		
		return responseDto;
	}
}
