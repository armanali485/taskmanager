package com.syntaxzero.taskmanager.dto;

import org.mapstruct.Mapper;

import com.syntaxzero.taskmanager.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	User toEntity(UserDTO u);
	UserDTO toUserDto(User u);
}
