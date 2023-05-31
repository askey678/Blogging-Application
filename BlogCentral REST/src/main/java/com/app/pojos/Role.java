package com.app.pojos;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Role extends BaseEntity {

	private String roleName;

}
