package com.example.groupe2.readflex.services;

import com.example.groupe2.readflex.configuration.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    @Autowired
    SecurityConfig securityConfig;


    public String HashPassword(String password) {
        PasswordEncoder encoder = securityConfig.passwordEncoder();
        return encoder.encode(password);
    }

    public Boolean VerifyPassword(String password, String hashedPassword) {
        PasswordEncoder encoder = securityConfig.passwordEncoder();
        return encoder.matches(password, hashedPassword);
    }

}
