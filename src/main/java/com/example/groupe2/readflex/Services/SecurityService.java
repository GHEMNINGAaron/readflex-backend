package com.example.groupe2.readflex.Services;

import com.example.groupe2.readflex.configuration.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    @Autowired
    SecurityConfig securityConfig;

    PasswordEncoder encoder = securityConfig.passwordEncoder();

    public String HashPassword(String password) {
        return encoder.encode(password);
    }

    public Boolean VerifyPassword(String password, String hashedPassword) {
        return encoder.matches(password, hashedPassword);
    }

}
