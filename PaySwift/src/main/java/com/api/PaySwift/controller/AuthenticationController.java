package com.api.PaySwift.controller;

import com.api.PaySwift.dto.AuthenticationDto;
import com.api.PaySwift.dto.LoginRespondeDto;
import com.api.PaySwift.dto.RegisterLoginDto;
import com.api.PaySwift.entity.UserModel;
import com.api.PaySwift.repository.UserRepository;
import com.api.PaySwift.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDto authRequest) {

        var userLogin = new UsernamePasswordAuthenticationToken(authRequest.login(), authRequest.password());
        var auth = authenticationManager.authenticate(userLogin);

        var token = tokenService.generateToken((UserModel) auth.getPrincipal());
        return ResponseEntity.ok(new LoginRespondeDto(token));
    }


    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody @Valid RegisterLoginDto registerLoginDto) {

        if (this.userRepository.findByLogin(registerLoginDto.login()) != null)
            return ResponseEntity.badRequest().build();

        String encrypted = new BCryptPasswordEncoder().encode(registerLoginDto.password());
        UserModel userModel = new UserModel(registerLoginDto.login(), encrypted, registerLoginDto.role());
        this.userRepository.save(userModel);


        return ResponseEntity.status(HttpStatus.CREATED).body("New User Created !!!");
    }

}
