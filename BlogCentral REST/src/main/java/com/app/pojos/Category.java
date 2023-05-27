package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "Categories")
public class Category extends BaseEntity {
	
	@Column(name="Title", length=50)
	private String categoryTitle;
	
	@Column(name="Description")
	private String categoryDescription;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL )
	private List<Post> posts = new ArrayList<Post>();
}
