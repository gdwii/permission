package com.gdwii;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gdwii.model.User;

@RestController
public class UserApi {
	public UserApi() {
		System.out.println("start user api");
	}
	
	@RequestMapping(value="/api/user/{id}", method=RequestMethod.GET)
	public User get(@PathVariable int id){
		User user = new User();
		user.setId(id);
//		user.setBirthday(LocalDateTime.now());
		user.setName("gdw");
		return user;
	}
	
	@RequestMapping(value="/api/user", method=RequestMethod.POST)
	public User update(User user, String s){
//		System.out.println(s);
		System.out.println(user);
//		return user;
		return new User();
	}
}
