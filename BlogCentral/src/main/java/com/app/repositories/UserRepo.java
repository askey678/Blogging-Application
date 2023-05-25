package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
