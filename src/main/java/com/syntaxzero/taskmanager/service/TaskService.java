package com.syntaxzero.taskmanager.service;



import com.syntaxzero.taskmanager.dto.TaskDTO;
import com.syntaxzero.taskmanager.model.Task;

public interface TaskService {
	
	Task createTask(TaskDTO task);
	
	void deleteTask(Long id);
	
}
