package com.greengear.auth.service;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.greengear.auth.Dto.SignInDTO;
import com.greengear.auth.Entities.User;
import com.greengear.auth.Repository.UserReposipory;


@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
	@Mock
	public UserReposipory reposipory;
	
	@InjectMocks
	public UserServiceImpl service;
	@Test
	public void signIn() {
	    SignInDTO dto = new SignInDTO();
	    dto.setEmail("deepak@gmail.com");
	    dto.setPassword("Deepak@123"); // Raw password

	    User mockUser = new User();
	    mockUser.setEmail("deepak@gmail.com");
	    

	    // Mock repository
	    when(reposipory.findByEmail(dto.getEmail())).thenReturn(Optional.of(mockUser));
	    Optional<User> byEmail = reposipory.findByEmail(dto.getEmail());
	    Assertions.assertTrue(byEmail.isPresent());
	    Assertions.assertEquals(dto.getEmail(), byEmail.get().getEmail());


	}

		

}
