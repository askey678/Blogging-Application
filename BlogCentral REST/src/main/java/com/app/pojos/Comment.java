package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Comment extends BaseEntity {

	private String content;

	@ManyToOne
	private Post post;

	@ManyToOne
	private User user;

}
