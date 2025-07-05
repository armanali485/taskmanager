package com.syntaxzero.taskmanager.response;

import com.syntaxzero.taskmanager.exception.ResourceNotFoundException;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseAPI<T> {
	
	private String message;
	private T data;
	private boolean status;

}
