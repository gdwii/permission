package com.gdwii.permission.controller;

import com.gdwii.permission.service.UserService;
import com.gdwii.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gdwii.permission.model.User;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value="/user", method=RequestMethod.POST)
	public Result add(User user){
		return userService.addUser(user);
	}

	@RequestMapping(value="/user/{usreId}", method=RequestMethod.GET)
	public User get(@PathVariable  Integer usreId){
		return userService.getUserWithRole(usreId);
	}
}
