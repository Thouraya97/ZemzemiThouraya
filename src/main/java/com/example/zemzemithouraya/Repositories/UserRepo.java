package com.example.zemzemithouraya.Repositories;

import com.example.zemzemithouraya.Entities.User;
import com.example.zemzemithouraya.Enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Integer> {
        public List<User> findUsersByRoleIs(Role role);
}
