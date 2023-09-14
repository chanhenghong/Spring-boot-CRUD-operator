package com.acleda.crud.controller;

import com.acleda.crud.base.Rest;
import com.acleda.crud.dto.LoginDto;
import com.acleda.crud.dto.RegisterDto;
import com.acleda.crud.entity.Role;
import com.acleda.crud.entity.User;
import com.acleda.crud.repositorty.RoleRepository;
import com.acleda.crud.repositorty.UserRepository;
import com.acleda.crud.service.RoleService;
import com.acleda.crud.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collections;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    private RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("login")
    public Rest<?> login(@RequestBody LoginDto loginDto){

        String token = userService.loing(loginDto);

        return Rest.builder()
                .message("You has been login successfully!")
                .code(HttpStatus.OK.value())
                .status(true)
                .timestamp(Timestamp.valueOf(LocalDateTime.now()))
                .data(token)
                .build();
    }

    @PostMapping("register")
    public Rest<?> register(@RequestBody RegisterDto registerDto){
        if(userService.existsByUsername(registerDto.getUsername())){
            return Rest.builder().message("Username is taken!")
                    .code(HttpStatus.BAD_REQUEST.value())
                    .status(false)
                    .timestamp(Timestamp.valueOf(LocalDateTime.now()))
                    .build();
        }
        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(registerDto.getPassword()));

        Role role = roleService.findRoleByName("USER").get();
        user.setRoles(Collections.singletonList(role));

        User user1 = userService.saveUser(user);

        return Rest.builder()
                .message("You has been login successfully!")
                .code(HttpStatus.OK.value())
                .status(true)
                .timestamp(Timestamp.valueOf(LocalDateTime.now()))
                .data(user1)
                .build();
    }

}
