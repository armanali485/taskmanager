package com.syntaxzero.taskmanager.service;

import java.util.List;


import com.syntaxzero.taskmanager.dto.UserDTO;
import com.syntaxzero.taskmanager.model.User;


public interface UserService {
	
	User saveUser(UserDTO user);
	List<User> findAll();
	UserDTO deleteById(int id);
	
	User findById(int id);

}
