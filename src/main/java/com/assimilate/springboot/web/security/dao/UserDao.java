package com.assimilate.springboot.web.security.dao;

import org.springframework.stereotype.Repository;

import com.assimilate.springboot.web.security.model.User;

@Repository
public interface UserDao {

	void newUser(User user);

	User getUser(String username);

	
		
		
	
}
