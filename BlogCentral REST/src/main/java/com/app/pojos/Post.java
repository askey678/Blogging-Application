package com.app.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "Posts")
public class Post extends BaseEntity {

	@Column(name = "post_title", length = 100, nullable = false)
	private String title;

	@Column(length = 500)
	private String content;

	private String imageName;

	private Date addedDate;

	@ManyToOne
	@JoinColumn(name = "category_Id")
	private Category category;

	@ManyToOne
	private User user;
}
