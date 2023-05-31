package com.app.payloads;

import java.util.HashSet;
import java.util.Set;

import com.app.pojos.Comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {

	private Long id;

	private String title;

	private String content;

	private String imageName;

	private String addedDate;

	private UserDto userDto;

	private CategoryDto categoryDto;

	private Set<CommentDto> comments = new HashSet<CommentDto>();

}
