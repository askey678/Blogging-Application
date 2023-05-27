package com.app.services;

import java.util.List;

import com.app.payloads.UserDto;

public interface UserService {

	UserDto createUser(UserDto user);

	UserDto updateUser(UserDto user, Long userId);

	void deleteUser(Long userId);

	UserDto getUser(Long userId);

	List<UserDto> getAllUsers();

}
