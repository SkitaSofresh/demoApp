package com.conversate.demoApp.repository;

import com.conversate.demoApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
