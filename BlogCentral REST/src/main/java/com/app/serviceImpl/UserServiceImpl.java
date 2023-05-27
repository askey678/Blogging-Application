package com.app.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exceptions.ResourceNotFoundException;
import com.app.payloads.UserDto;
import com.app.pojos.User;
import com.app.repositories.UserRepo;
import com.app.services.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper modelmapper;

	private User dtoToUser(UserDto userdto) {
		User user = modelmapper.map(userdto, User.class);
		return user;
	}

	private UserDto userToDto(User user) {
		UserDto userdto = modelmapper.map(user, UserDto.class);
		return userdto;
	}

	@Override
	public UserDto createUser(UserDto userdto) {
		User user = dtoToUser(userdto);
		User saveduser = userRepo.save(user);
		return userToDto(saveduser);
	}

	@Override
	public UserDto updateUser(UserDto userdto, Long userId) {
		User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		user.setEmail(userdto.getEmail());
		user.setName(userdto.getName());
		user.setPassword(userdto.getPassword());
		user.setAbout(userdto.getAbout());
		User updatedUser = userRepo.save(user);
		return userToDto(updatedUser);
	}

	@Override
	public void deleteUser(Long userId) {
		User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		userRepo.delete(user);

	}

	@Override
	public UserDto getUser(Long userId) {
		User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		return userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userRepo.findAll();
		List<UserDto> userdtos = users.stream().map(user -> userToDto(user)).collect(Collectors.toList());
		return userdtos;
	}

}
