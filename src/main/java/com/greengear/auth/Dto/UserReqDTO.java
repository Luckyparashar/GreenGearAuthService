package com.greengear.auth.Dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserReqDTO {

	    @NotBlank
	    private String userName;
	    @Email
	    private String email;
	
	    private String password;
	    @NotBlank
	    private String phone;
	    @NotBlank
	    private String role;
	    @NotBlank
	    private String city;
	    @NotBlank
	    private String state;
	    @NotNull(message = "Date of birth is required")
	    @Past(message = "Date of birth must be in the past")
	    private LocalDate dateOfBirth;
	    @NotNull(message = "Verification status must be specified")
	    private boolean isVerified;
}
