package com.greengear.auth.Entities;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name="users")
//id and creation time coming from base entity
@NoArgsConstructor
public class User extends BaseEntity implements UserDetails {
	@Column(nullable = false)
private String userName;
@Column(nullable = false,unique = true)
private String phone;
@Column(unique = true,nullable = false)
private String email;
@Column(nullable = false)
private String password;
@Enumerated(EnumType.STRING)
@Column(name = "user_role")
private UserRole role; 
@Column(nullable = false)// consider using Enum
private String city;
@Column(nullable = false)
private String state;
@Lob
private byte[] image;
@Column(name="dob",nullable = false)
private LocalDate dateOfBirth;
@Column(name = "is_verified", nullable = false)
private boolean isVerified;



public User(String userName ,String email, String password, LocalDate dob, UserRole role,String phone,String city,String state) {
	super();
	this.userName = userName;
	this.phone=phone;
	this.email = email;
	this.password = password;
	this.dateOfBirth = dob;
	this.role = role;
	this.city=city;
	this.state=state;
}
@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	// TODO Auto-generated method stub
	return List.of(new SimpleGrantedAuthority(this.role.name()));
}

@Override
public String getUsername() {
	// TODO Auto-generated method stub
	return this.email;
}
public String getName() {
	// TODO Auto-generated method stub
	return this.userName;
}

}
