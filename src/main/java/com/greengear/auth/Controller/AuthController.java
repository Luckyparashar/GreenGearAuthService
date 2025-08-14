package com.greengear.auth.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greengear.auth.Dto.AuthResp;
import com.greengear.auth.Dto.SignInDTO;
import com.greengear.auth.Dto.UserReqDTO;
import com.greengear.auth.Security.JwtUtils;
import com.greengear.auth.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class AuthController {

private final UserService userService;


/*
 * Desc - sign in
 * URL - http://host:port/users/signin
 * Method - POST
 * Payload - signin dto 
 * Successful Resp -SC 200 ,body - mesg , JWT
 * failed - SC 401 , err mesg - api resp
 */
@PostMapping("/signin")
@Operation(description = "User sign in ")
public ResponseEntity<?> userSignIn(@RequestBody SignInDTO dto) {
	System.out.println("in sign in "+dto);
	
	
	return ResponseEntity.status(HttpStatus.CREATED)//SC 201
			.body(userService.signIn(dto));
}
/*
 * - Desc - User registration
 *  URL - http://host:port/users/signup
 * Method - POST
	payload -user signup req dto
	resp - SC 201 , user resp  dto 
	error - dup email - SC 400 | SC 409 , api resp - error mesg
 */
@PostMapping("/signup")
public ResponseEntity<?> signupUser(@RequestBody @Valid
		UserReqDTO dto)
{
	System.out.println("in signup "+dto);
	return ResponseEntity
			.status(HttpStatus.CREATED)
			.body(userService.signUp(dto));
			
}

}
