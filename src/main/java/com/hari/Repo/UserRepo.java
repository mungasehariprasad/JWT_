package com.hari.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hari.Entities.User;

public interface UserRepo extends JpaRepository<User, String> {
    public Optional<User> findByEmail(String email);
}
