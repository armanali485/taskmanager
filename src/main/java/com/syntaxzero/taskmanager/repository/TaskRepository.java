package com.syntaxzero.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syntaxzero.taskmanager.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
	
	

}
