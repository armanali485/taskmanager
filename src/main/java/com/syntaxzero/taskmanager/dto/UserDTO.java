package com.syntaxzero.taskmanager.dto;

import com.syntaxzero.taskmanager.model.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
	@NotEmpty(message = "name should not be empty")
	@Pattern(regexp = "^[A-Z][a-z]+(?: [A-Z][a-z]+)*$", message = "should not contains number")
	private String name;
	
	@Email(message = "please enter valid email")
	private String email;
	
	
	private Role role;
	
	
	
	private String password;

}
