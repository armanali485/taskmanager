package com.syntaxzero.taskmanager.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syntaxzero.taskmanager.dto.TaskDTO;
import com.syntaxzero.taskmanager.response.ResponseAPI;
import com.syntaxzero.taskmanager.service.TaskService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tasks")
public class TaskController {
	private final TaskService taskService;
	
	@PostMapping("/create")
	public ResponseEntity<ResponseAPI<TaskDTO>> createTask(@Valid @RequestBody  TaskDTO taskDTO){
		taskService.createTask(taskDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(ResponseAPI.<TaskDTO>builder()
				.message("Task Added")
				.status(true)
				.data(taskDTO)
				.build());
	}

}
