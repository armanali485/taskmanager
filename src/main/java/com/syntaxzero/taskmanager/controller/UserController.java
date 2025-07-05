package com.syntaxzero.taskmanager.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syntaxzero.taskmanager.dto.UserDTO;
import com.syntaxzero.taskmanager.model.User;
import com.syntaxzero.taskmanager.response.ResponseAPI;
import com.syntaxzero.taskmanager.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/api/users")
public class UserController {
	private final UserService userService;
	
	@GetMapping("/getall")
	public ResponseEntity<List<User>> getAll(){
		return ResponseEntity.ok(userService.findAll());
	}
	@PostMapping("/register")
	public ResponseEntity<ResponseAPI<UserDTO>> post(@Valid @RequestBody UserDTO userDTO){
		userService.saveUser(userDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseAPI<UserDTO>("User Created", userDTO,true));
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseAPI<UserDTO>> delete(@PathVariable int id){
		UserDTO userDTO = userService.deleteById(id);
		return ResponseEntity.status(HttpStatus.GONE).body(new ResponseAPI<UserDTO>("deleted",userDTO,true));
	}
	
	

}
