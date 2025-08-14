package com.greengear.auth.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greengear.auth.Dto.CustomUserPrincipal;
import com.greengear.auth.Dto.UserReviewDTO;
import com.greengear.auth.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("user/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/batch")
    public List<UserReviewDTO> getUsersByIds(@RequestParam("ids") List<Long> ids) {
        return userService.getUsersByIds(ids);
    }
    @GetMapping("/me")
    public ResponseEntity<?> getUsersById( @AuthenticationPrincipal CustomUserPrincipal details) {
    	
    	
        return ResponseEntity.ok(userService.getUsersById(details.getUserId()));
    }
    
    
}
