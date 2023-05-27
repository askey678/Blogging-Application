package com.app.payloads;

import com.app.pojos.Category;
import com.app.pojos.User;

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

	private User user;

	private Category category;

}
