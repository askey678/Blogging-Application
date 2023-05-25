package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@ToString(exclude = "password")

@Entity
@Table(name = "User")
public class User extends BaseEntity {

	@Column(length = 50, nullable = false)
	private String name;
	@Column(length = 50, nullable = false)
	private String email;
	@Column(length = 30, nullable = false)
	private String password;
	@Column(length = 250, nullable = false)
	private String about;

}
