package com.baylab.project.domain.service;

import com.baylab.project.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserStorage extends JpaRepository<User,Integer> {

}
