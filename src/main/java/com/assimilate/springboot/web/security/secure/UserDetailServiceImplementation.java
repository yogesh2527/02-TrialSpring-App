package com.assimilate.springboot.web.security.secure;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import com.assimilate.springboot.web.security.dao.UserDao;
import com.assimilate.springboot.web.security.model.User;

@Service
public class UserDetailServiceImplementation implements UserDetailsService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		
		User user= userDao.getUser(username);
		
		Set<GrantedAuthority> grantedAuthority = new HashSet<GrantedAuthority>();
		
		grantedAuthority.add(new SimpleGrantedAuthority("USER"));
		
		if(user==null)
		{
			throw new UsernameNotFoundException("userName or Password Incorrect");
		}

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthority);
	}

}
