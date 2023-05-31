package com.app.serviceImpl;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exceptions.ResourceNotFoundException;
import com.app.payloads.CommentDto;
import com.app.pojos.Comment;
import com.app.pojos.Post;
import com.app.pojos.User;
import com.app.repositories.CommentRepo;
import com.app.repositories.PostRepo;
import com.app.repositories.UserRepo;
import com.app.services.CommentService;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CommentRepo commentRepo;

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private UserRepo userRepo;

	@Override
	public CommentDto createComment(CommentDto commentDto, Long postId, Long userId) {

		Post post = postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "PostId", postId));
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "UserId", userId));

		Comment comment = modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		comment.setUser(user);
		Comment createdComment = commentRepo.save(comment);
		return modelMapper.map(createdComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Long commentId) {
		Comment comment = commentRepo.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment", "comment Id", commentId));
		commentRepo.delete(comment);

	}

}
