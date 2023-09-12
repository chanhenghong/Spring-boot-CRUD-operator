package com.acleda.crud.controller;

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

import java.util.Collections;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    private RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final DaoAuthenticationProvider daoAuthenticationProvider;

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto){

        String token = userService.loing(loginDto);

        return ResponseEntity.ok(token);
    }

    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody RegisterDto registerDto){
        if(userService.existsByUsername(registerDto.getUsername())){
            return new ResponseEntity<>("Username is taken!", HttpStatus.BAD_REQUEST);
        }
        log.info("Heng::: = {}", registerDto);
        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(registerDto.getPassword()));

        Role role = roleService.findRoleByName("USER").get();
        user.setRoles(Collections.singletonList(role));

        User user1 = userService.saveUser(user);

//        return new ResponseEntity<>("User registerd successfully!", HttpStatus.OK);
        return ResponseEntity.ok(user1);
    }

}
