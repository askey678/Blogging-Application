package com.app.services;

import java.util.List;

import com.app.payloads.PostDto;

public interface PostService {

	// create
	public PostDto createPost(PostDto postdto);

	// update
	public PostDto updatePost(PostDto postdto, Long postId);

	// delete
	public void deletePost(Long postId);

	// getById
	public PostDto getPostById(Long postId);

	// getAll
	public List<PostDto> getAllPost();

}
