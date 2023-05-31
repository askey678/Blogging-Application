package com.app.payloads;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostResponse {
	
	private List<PostDto> content;
	
	private int pageNumber;
	
	private int pageSize;
	
	private int totalElements;
	
	private long totalPages;
	
	private boolean isLastPage;

}
