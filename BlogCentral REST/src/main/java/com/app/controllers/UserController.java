package com.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.payloads.ApiResponse;
import com.app.payloads.UserDto;
import com.app.services.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/")
	private ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userdto) {
		UserDto createdUser = userService.createUser(userdto);
		return new ResponseEntity<UserDto>(createdUser, HttpStatus.CREATED);

	}

	@GetMapping("/")
	private ResponseEntity<List<UserDto>> getAllUsers() {
		return ResponseEntity.ok(userService.getAllUsers());

	}

	@GetMapping("/{userId}")
	private ResponseEntity<UserDto> getUserById(@PathVariable Long userId) {
		UserDto userdto = userService.getUser(userId);
		return new ResponseEntity<>(userdto, HttpStatus.FOUND);
	}

	@PutMapping("/{userId}")
	private ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userdto, @PathVariable Long userId) {
		UserDto updatedUser = userService.updateUser(userdto, userId);
		return ResponseEntity.ok(updatedUser);

	}

	@DeleteMapping("/{userId}")
	private ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Long uId) {
		userService.deleteUser(uId);
		return new ResponseEntity<>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);

	}

}
