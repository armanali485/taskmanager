package com.syntaxzero.taskmanager.dto;

import org.mapstruct.Mapper;

import com.syntaxzero.taskmanager.model.Task;

@Mapper(componentModel = "spring")
public interface TaskMapper {
	
	Task toTask(TaskDTO t);
	
	TaskDTO toTaskDto(Task t);
	

}
