package com.assimilate.springboot.web.security.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.assimilate.springboot.web.security.model.Student;
import com.assimilate.springboot.web.security.model.User;
import com.mysql.cj.jdbc.SuspendableXAConnection;

@Service
public class UserDaoImplementation implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void newUser(User user) {
		
		
		System.out.println("In USer DAo");
		String query="insert into user(username,lastName,mobileNumber,password)"+"values(?,?,?,?)";
		
		int i = jdbcTemplate.update(query, user.getUsername(),user.getLastName(),user.getMobileNumber(),user.getPassword());
		
		
		if(i>0)
		{
			System.out.println("New user Added to Database");
		}
		else {
			System.out.println("Operation UnSuccessfull");
		}
	}

	@Override
	public User getUser(String username) {
		
		
		String query="select * from user where username ='"+username+"'";
		
		
		List<User> users = jdbcTemplate.query(query, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
	
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setLastName(rs.getString("lastName"));
				user.setMobileNumber(rs.getInt("mobileNumber"));
				user.setPassword(rs.getString("password"));
				
				return user;
			}
			
			
		});
		

		if (users.isEmpty()) {
			return null;
		} else
			return users.get(0);

	}

}
