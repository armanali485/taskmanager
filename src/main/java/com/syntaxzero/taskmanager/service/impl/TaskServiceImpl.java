package com.syntaxzero.taskmanager.service.impl;

import org.springframework.stereotype.Service;

import com.syntaxzero.taskmanager.dto.TaskDTO;
import com.syntaxzero.taskmanager.exception.ResourceNotFoundException;
import com.syntaxzero.taskmanager.model.Task;
import com.syntaxzero.taskmanager.model.User;
import com.syntaxzero.taskmanager.repository.TaskRepository;
import com.syntaxzero.taskmanager.repository.UserRepository;
import com.syntaxzero.taskmanager.service.TaskService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {
	
	private final UserRepository userRepository;
	private final TaskRepository taskRepository;

	@Override
	public Task createTask(TaskDTO taskDTO) {
		User u = userRepository.findById(taskDTO.getUserId()).orElseThrow(()->new ResourceNotFoundException("user with passed id is not present"));
		
		Task task = Task.builder().tittle(taskDTO.getTittle()).description(taskDTO.getDescription()).createdBy(u).build();
		return taskRepository.save(task);
	}

	@Override
	public void deleteTask(Long id) {
		Task t = taskRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("No Such task found"));
		taskRepository.delete(t);
		
	}

}
