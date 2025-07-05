package com.syntaxzero.taskmanager.service.impl;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.syntaxzero.taskmanager.dto.UserDTO;
import com.syntaxzero.taskmanager.dto.UserMapper;
import com.syntaxzero.taskmanager.exception.ResourceNotFoundException;
import com.syntaxzero.taskmanager.model.User;
import com.syntaxzero.taskmanager.repository.UserRepository;
import com.syntaxzero.taskmanager.service.UserService;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final UserMapper userMapper;
	private final PasswordEncoder passwordEncoder;
	@Override
	public User saveUser(UserDTO userDTO) {
		userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		return userRepository.save(User.builder()
				.email(userDTO.getEmail())
				.name(userDTO.getName())
				.password(userDTO.getPassword())
				.role(userDTO.getRole())
				.build()
				);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public UserDTO deleteById(int id) {
		User u = findById(id);
		userRepository.delete(u);
		return userMapper.toUserDto(u);
		

	}

	@Override
	public User findById(int id) {
		return userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User is not found"));
	}
	

}
