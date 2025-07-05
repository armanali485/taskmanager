package com.syntaxzero.taskmanager.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.syntaxzero.taskmanager.response.ResponseAPI;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	
	@ExceptionHandler(exception = ResourceNotFoundException.class)
	public ResponseEntity<ResponseAPI<String>> resoursceError(ResourceNotFoundException e){
		return ResponseEntity.badRequest().body(new ResponseAPI<String>(e.getMessage(),"Resource not found",false));
	}
	
	@ExceptionHandler(exception = MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseAPI<Map<String, String>>> invalidArugement(MethodArgumentNotValidException e){
		 Map<String, String> errors = new HashMap<>();

	        e.getBindingResult().getAllErrors().forEach((error) -> {
	            String fieldName = ((FieldError) error).getField();
	            String errorMessage = error.getDefaultMessage();
	            errors.put(fieldName, errorMessage);
	        });
	        ResponseAPI<Map<String, String>> ra = new ResponseAPI<Map<String, String>>();
	        ra.setMessage("Invalid Input");
	        ra.setStatus(false);
	        ra.setData(errors);
	        return ResponseEntity.badRequest().body(ra);
	}

}
