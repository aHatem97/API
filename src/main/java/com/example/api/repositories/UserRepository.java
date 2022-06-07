package com.example.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.api.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> 
{
	@Query("SELECT u FROM User u WHERE u.isDeleted=false")
	User findByUsername(@Param("username") String username);
	
	@Override
	@Query("SELECT u FROM User u WHERE u.isDeleted=false")
	List<User> findAll();

	//recycle bin
	@Query("SELECT u FROM User u WHERE u.isDeleted=true")
	List<User> recycleBin(); 

	@Query("UPDATE FROM User u SET u.isDeleted=true WHERE u.userId=:uid")
	@Modifying
	@Transactional
	void softDelete(@Param("uid") long uid); 
}
