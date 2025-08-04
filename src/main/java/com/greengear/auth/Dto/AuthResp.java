package com.greengear.auth.Dto;

import com.greengear.auth.Entities.UserRole;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AuthResp {
	private String message;
	private String jwt;
	private String userName;
	private UserRole role;
}
