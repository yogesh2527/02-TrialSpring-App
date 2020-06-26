package com.assimilate.springboot.web.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.assimilate.springboot.web.security.dao.UserDao;
import com.assimilate.springboot.web.security.model.User;


@Service
public class UserServiceImplementation implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void createUser(User user) {
		
		System.out.println("In Password ");
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userDao.newUser(user);
	}

	@Override
	public User getUserByUserName(String firstName) {
		
		return userDao.getUser(firstName);
	}

}
