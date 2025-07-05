package com.syntaxzero.taskmanager.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDTO {
	
	@NotEmpty(message = "Tittle should not be blank")
	private String tittle;
	
	@NotEmpty(message = "Description should not be blank")
	private String description;
	
	private int userId;
	

}
