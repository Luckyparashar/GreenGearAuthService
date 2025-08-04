package com.greengear.auth.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greengear.auth.Dto.ApiResponse;
import com.greengear.auth.Dto.AuthResp;
import com.greengear.auth.Dto.SignInDTO;
import com.greengear.auth.Dto.UserReqDTO;
import com.greengear.auth.Dto.UserResDTO;
import com.greengear.auth.Dto.UserReviewDTO;
import com.greengear.auth.Entities.User;
import com.greengear.auth.Exception.ApiException;
import com.greengear.auth.Repository.UserReposipory;
import com.greengear.auth.Security.JwtUtils;

import lombok.AllArgsConstructor;
@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserReposipory reposipory;
	private final ModelMapper mapper;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;
	private final JwtUtils jwtUtils;

	@Override
	public ApiResponse signUp(UserReqDTO dto) {
		// 1. check for dup email
		if (reposipory.existsByEmail(dto.getEmail()))
			throw new ApiException("Dup Email detected - User exists already!!!!");
		// 2. dto -> entity

		User entity = mapper.map(dto, User.class);
		//3 encrypt password
		entity.setPassword(passwordEncoder.encode(entity.getPassword()));
		//4. save the entity
		reposipory.save(entity);
		return new ApiResponse("successfully ragister...");
	}


	@Override
	public AuthResp signIn(SignInDTO dto) {
		Authentication authToken=	new
				UsernamePasswordAuthenticationToken(dto.getEmail(),
						dto.getPassword());
				System.out.println("before - "+authToken.isAuthenticated());//false
				Authentication validAuth = 
						authenticationManager.authenticate(authToken);
				//=> success
				System.out.println("after - "+validAuth.isAuthenticated());//true
				System.out.println(validAuth);//user details : UserEntity
				//2. Create signed JWT n send it in the response.
				String jwtToken = jwtUtils.generateJwtToken(validAuth);
				 User user = reposipory.findByEmail(dto.getEmail()).orElseThrow(()->new UsernameNotFoundException("not found"));
				return new AuthResp("Succesful login !",jwtToken,user.getName(),user.getRole());
		
	}


	@Override
	public List<UserReviewDTO> getUsersByIds(List<Long> ids) {
		List<User> allById = reposipory.findAllById(ids);

		
		
				List<UserReviewDTO> list = allById.stream().map(u->mapper.map(u, UserReviewDTO.class)).toList();
				
				return list;
	}


	@Override
	public UserResDTO getUsersById(Long userId) {
		User user = reposipory.findById(userId).orElseThrow(()->new ApiException("user not found"));
		UserResDTO userResDTO = mapper.map(user, UserResDTO.class);
		userResDTO.setUserName(user.getName());
		return userResDTO;
	}

	

}
