package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Post;

public interface PostRepo extends JpaRepository<Post, Long> {

}
