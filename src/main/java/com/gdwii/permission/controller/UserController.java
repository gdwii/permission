package com.gdwii.permission.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gdwii.permission.model.User;

@RestController
public class UserController {
	public UserController() {
		System.out.println("start user api");
	}
	
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public ResponseEntity<?> add(User user){
		HttpHeaders httpHeaders = new HttpHeaders();
		/*httpHeaders.setLocation(ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(user.getId()).toUri());*/
		return new ResponseEntity<>(user, httpHeaders, HttpStatus.NOT_FOUND);
	}
}
