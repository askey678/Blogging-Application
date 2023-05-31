package com.app.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private Long id;

	@NotEmpty
	@Size(min = 4, message = "UserName must be minimum of 4 characters")
	private String name;

	@Email(message = "Your Email Address is not Valid!!")
	private String email;

	@NotEmpty
	@Size(min = 5, max = 15, message = "Password must be minimum of 3 chars and maximum of 15 chars")
//	@Pattern(regexp= )
	private String password;

	@NotEmpty
	private String about;

}
