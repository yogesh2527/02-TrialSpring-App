package com.assimilate.springboot.web.security.services;

import org.springframework.stereotype.Repository;

import com.assimilate.springboot.web.security.model.User;


@Repository
public interface UserService {

	public void createUser(User user);

		public User getUserByUserName(String firstName);
	
	
	

}
