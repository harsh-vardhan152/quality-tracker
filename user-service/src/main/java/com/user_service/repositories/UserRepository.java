package com.user_service.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.user_service.entities.User;

public interface UserRepository extends JpaRepository<User,Long>
{
	
	Optional<User> findByEmail(String email);
	
	@Query("select u from User u where u.email = :email")
	public User getUserByEmail(@Param("email")String email);
	
	
}
