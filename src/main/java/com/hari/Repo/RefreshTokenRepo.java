package com.hari.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hari.Entities.RefreshToken;

public interface RefreshTokenRepo extends JpaRepository<RefreshToken, String> {
    Optional<RefreshToken> findByrefreshToken(String token);

}
