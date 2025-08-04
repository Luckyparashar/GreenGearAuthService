package com.greengear.auth.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greengear.auth.Entities.User;

public interface UserReposipory extends JpaRepository<User, Long> {
	// derived method
		Optional<User> findByEmailAndPassword(String email, String password);

		// derived finder
		boolean existsByEmail(String email);

		// derived finder
		Optional<User> findByEmail(String email);

		// derived finder
		List<User> findByCity(String city);
}
