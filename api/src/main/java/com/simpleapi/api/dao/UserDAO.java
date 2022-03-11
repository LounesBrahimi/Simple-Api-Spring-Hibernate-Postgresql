package com.simpleapi.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simpleapi.api.entity.User;

@Repository
public interface UserDAO  extends JpaRepository<User, Long>{

}
