package com.springboot.pp_3_1_2.repository;

import com.springboot.pp_3_1_2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
