package com.nesugo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nesugo.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	
	public Optional<UserEntity> findByUserName(String userName);

	//public Optional<>
}
