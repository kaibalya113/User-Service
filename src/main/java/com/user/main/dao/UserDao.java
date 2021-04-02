package com.user.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.main.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Long>{

	User findByUserId(Long userId);

}
