package com.xgrimau.storingpasswords.service;


import com.xgrimau.storingpasswords.repository.UserEntity;
import com.xgrimau.storingpasswords.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void registerUser(final String username, final String password) {
        var user = new UserEntity();
        user.setUsername(username);
        user.setHashedPassword(hashPassword(password));
        userRepository.save(user);
    }

    @SneakyThrows
    private String hashPassword(String password) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        return Base64.getEncoder().encodeToString(factory.generateSecret(spec).getEncoded());
    }
}
