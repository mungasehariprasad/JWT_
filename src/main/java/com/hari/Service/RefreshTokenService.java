package com.hari.Service;

import java.time.Instant;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hari.Entities.RefreshToken;
import com.hari.Entities.User;
import com.hari.Repo.RefreshTokenRepo;
import com.hari.Repo.UserRepo;

@Service
public class RefreshTokenService {

    public long refreshTokenValidity = 5 * 60 * 60 * 1000;
    @Autowired
    private RefreshTokenRepo refreshTokenRepo;

    @Autowired
    private UserRepo userRepo;

    public RefreshToken createRefreshToken(String userName) {
        User user = userRepo.findByEmail(userName).get();
        RefreshToken refreshToken1 = user.getRefreshToken();
        if (refreshToken1 == null) {
            refreshToken1 = RefreshToken.builder()
                    .refreshToken(UUID.randomUUID().toString())
                    .expiry(Instant.now().plusMillis(refreshTokenValidity))
                    .user(userRepo.findByEmail(userName).get())
                    .build();

        } else {
            refreshToken1.setExpiry(Instant.now().plusMillis(refreshTokenValidity));
        }
        user.setRefreshToken(refreshToken1);

        refreshTokenRepo.save(refreshToken1);
        return refreshToken1;
    }

    public RefreshToken verifyRefreshToken(String refreshToken) {
        RefreshToken refresh = refreshTokenRepo.findByrefreshToken(refreshToken)
                .orElseThrow(() -> new RuntimeException("Invalid refresh token: "));
        if (refresh.getExpiry().compareTo(Instant.now()) < 0) {
            refreshTokenRepo.delete(refresh);
            throw new RuntimeException("Refresh token Expired !!");
        }
        return refresh;

    }

}
