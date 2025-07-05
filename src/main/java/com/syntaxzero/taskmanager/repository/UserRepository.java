package com.syntaxzero.taskmanager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syntaxzero.taskmanager.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	@Override
	Optional<User> findById(Integer id);
	
	@Override
	List<User> findAll();

}
