package com.test.restful.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserService {

	private static List<User> userDetails = new ArrayList<>();
	private static int userCount=3;
	static {
		userDetails.add(new User(1, "dheshna", new Date()));
		userDetails.add(new User(2, "vinoothini", new Date()));
		userDetails.add(new User(3, "dilip", new Date()));
	}
	public List<User> findALl(){
		return userDetails;
	}
	
	public User findOne(int id) {
		for(User user:userDetails) {
			if(user.getId()==id) {
				return user;
			}
				
			
		}
		return null;
	}
	
	
	public User deleteById(int id) {
		Iterator<User> itr = userDetails.iterator();
		while (itr.hasNext()) {
			User user = (User) itr.next();
			if(user.getId()==id) {
				itr.remove();
				return user;
			}
		}
		return null;
	}
	
	
	public User save(User user) {
		if(user.getId()==null) {
			user.setId(++userCount);
		}
		userDetails.add(user);
		return user;
		}
	
	
}
