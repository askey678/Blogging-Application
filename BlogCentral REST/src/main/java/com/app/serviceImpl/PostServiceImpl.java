package com.app.serviceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.exceptions.ResourceNotFoundException;
import com.app.payloads.PostDto;
import com.app.pojos.Post;
import com.app.repositories.PostRepo;
import com.app.services.PostService;

public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private ModelMapper modelMapper;

	public Post dtoToPost(PostDto postDto) {
		return modelMapper.map(postDto, Post.class);
	}

	public PostDto postToDto(Post post) {
		return modelMapper.map(post, PostDto.class);
	}

	@Override
	public PostDto createPost(PostDto postdto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDto updatePost(PostDto postdto, Long postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(Long postId) {
		Post post = postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "PostId", postId));
		postRepo.delete(post);

	}

	@Override
	public PostDto getPostById(Long postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}

}
