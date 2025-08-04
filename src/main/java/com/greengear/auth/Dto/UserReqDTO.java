package com.greengear.auth.Dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserReqDTO {

	
	    private String userName;
	    private String email;
	    private String password;
	    private String phone;
	    private String role;
	    private String city;
	    private String state;
	    private LocalDate dateOfBirth;
	    private boolean isVerified;
}
