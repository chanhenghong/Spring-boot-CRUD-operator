package com.acleda.crud.service.impl;

import com.acleda.crud.entity.Role;
import com.acleda.crud.entity.User;
import com.acleda.crud.repositorty.UserRepository;
import com.acleda.crud.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
}
