package com.app.services;

import java.util.List;

import com.app.payloads.PostDto;
import com.app.payloads.PostResponse;
import com.app.pojos.Post;

public interface PostService {

	// create
	public PostDto createPost(PostDto postdto, Long UserId, Long CategoryId);

	// update
	public PostDto updatePost(PostDto postdto, Long postId);

	// delete
	public void deletePost(Long postId);

	// getById
	public PostDto getPostById(Long postId);

	// getAll
	public PostResponse getAllPost(Integer pageNumber, Integer pageSize);

	// getAllPostByUser
	public List<PostDto> getPostByUser(Long UserId);

	// getAllPostByCategory
	public List<PostDto> getPostByCategory(Long CategoryId);

	// searchPosts
	public List<PostDto> searchPosts(String keyword);

}
