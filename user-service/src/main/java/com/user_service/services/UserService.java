package com.user_service.services;

import java.util.List;
import com.user_service.entities.User;

public interface UserService {
	
	
	//Create a new User
	User saveUser(User user);
	
	
	//Get the new User
	List<User> getAllUser();
	
	
	//get single user of given User ID
	User getUser(int userId);
	
	
	//delete the user by Id
	void deleteUserById(int id);
	
	


}
