package com.greengear.auth.Service;

import java.util.List;

import com.greengear.auth.Dto.ApiResponse;
import com.greengear.auth.Dto.AuthResp;
import com.greengear.auth.Dto.SignInDTO;
import com.greengear.auth.Dto.UserReqDTO;
import com.greengear.auth.Dto.UserResDTO;
import com.greengear.auth.Dto.UserReviewDTO;
import com.greengear.auth.Exception.ApiException;

import jakarta.validation.Valid;

public interface UserService {

	ApiResponse signUp(@Valid UserReqDTO dto);
AuthResp signIn(SignInDTO dto);
List<UserReviewDTO> getUsersByIds(List<Long> ids);
UserResDTO getUsersById(Long userId);
	 
	    
	    
		  
}
