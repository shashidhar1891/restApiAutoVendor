package com.training.autoVendor.controller;

import com.training.autoVendor.model.AuthRequest;
import com.training.autoVendor.model.AuthResponse;
import com.training.autoVendor.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutoTokenContoller {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/token")
    public ResponseEntity<?> getToken(@RequestBody AuthRequest request) {
        if ("autoUser".equals(request.getUsername()) && "autoPassword".equals(request.getPassword())) {
            String token = jwtUtil.generateToken(request.getUsername());
            return ResponseEntity.ok(new AuthResponse(token));
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }

}
