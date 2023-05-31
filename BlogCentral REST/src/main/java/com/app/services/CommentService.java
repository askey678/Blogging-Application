package com.app.services;

import com.app.payloads.CommentDto;

public interface CommentService {
	
	CommentDto createComment(CommentDto commentDto, Long postId, Long userId);
	
	void deleteComment(Long commentId);
	

}
