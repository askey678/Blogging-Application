package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Category;
import com.app.pojos.Post;
import com.app.pojos.User;

public interface PostRepo extends JpaRepository<Post, Long> {

	// custom finders methods:-

	List<Post> findByUser(User user);

	List<Post> findByCategory(Category catg);

}
