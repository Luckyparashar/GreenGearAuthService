package com.greengear.auth.Dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserResDTO {

	
	    private String userName;
	    private String email;
	    
	    private String phone;
	    private String role;
	    private String city;
	    private String state;
	    private LocalDate dateOfBirth;
	    private boolean isVerified;
}
