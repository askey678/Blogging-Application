package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.payloads.ApiResponse;
import com.app.payloads.PostDto;
import com.app.payloads.PostResponse;
import com.app.services.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {

	@Autowired
	public PostService postService;

	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postdto, @PathVariable Long userId,
			@PathVariable Long categoryId) {
		PostDto createdPostdto = postService.createPost(postdto, userId, categoryId);
		return new ResponseEntity<PostDto>(createdPostdto, HttpStatus.CREATED);

	}

	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Long userId) {
		List<PostDto> postdtos = postService.getPostByUser(userId);
		return new ResponseEntity<List<PostDto>>(postdtos, HttpStatus.OK);
	}

	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Long categoryId) {
		List<PostDto> postdtos = postService.getPostByCategory(categoryId);
		return new ResponseEntity<List<PostDto>>(postdtos, HttpStatus.OK);
	}

	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getAllPosts(
			@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
		return new ResponseEntity<PostResponse>(postService.getAllPost(pageNumber, pageSize), HttpStatus.OK);
	}

	@GetMapping("post/{postId}")
	public ResponseEntity<PostDto> getPostbyId(@PathVariable Long postId) {
		return ResponseEntity.ok(postService.getPostById(postId));
	}

	@DeleteMapping("post/{postId}")
	public ResponseEntity<ApiResponse> deletePost(@PathVariable Long postId) {
		postService.deletePost(postId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Post deleted Successfully", true), HttpStatus.OK);
	}

	@PutMapping("post/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postdto, @PathVariable Long postId) {
		return new ResponseEntity<PostDto>(postService.updatePost(postdto, postId), HttpStatus.OK);

	}
}
