package com.app.payloads;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {
	private Long id;
	@NotEmpty
	@Size(min=4,max=30)
	private String categoryTitle;
	@NotEmpty
	@Size(min=20, max=250)
	private String categoryDescription;

}
