package com.syntaxzero.taskmanager.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder 
public class LoginResponse {
	
	private String userEamil;
	
	private String password;

}
