package com.auth.server.demo.controller;

import com.auth.server.demo.config.ByCriptUtils;
import com.auth.server.demo.entity.UserEntity;
import com.auth.server.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping(value = "/auth")
public class TokenController {

    private final UserRepository repository;
    private final ByCriptUtils byCriptUtils;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public TokenController(UserRepository repository, ByCriptUtils byCriptUtils,
                           PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.byCriptUtils = byCriptUtils;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping()
    public ResponseEntity<?> registryUser(@RequestParam String user, @RequestParam String password) {
        if (repository.findByUserName(user).isPresent()) {
            return ResponseEntity.ok(byCriptUtils.generateToken(password));
        }
        UserEntity newUser = new UserEntity();
        newUser.setUserName(user);
        newUser.setPassword(passwordEncoder.encode(password));
        repository.save(newUser);
        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping()
    public ResponseEntity<?> loginBearerToken(@RequestParam String user, @RequestParam String password) {
        Optional<UserEntity> findUser = repository.findByUserName(user);
        if (findUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        UserEntity entity = findUser.get();
        if (!passwordEncoder.matches(password, entity.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
        }
        return ResponseEntity.ok(byCriptUtils.generateToken(password));
    }
}