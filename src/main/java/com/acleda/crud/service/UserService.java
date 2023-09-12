package com.acleda.crud.service;

import com.acleda.crud.dto.LoginDto;
import com.acleda.crud.entity.Role;
import com.acleda.crud.entity.User;

public interface UserService {
    User saveUser(User user);
    Boolean existsByUsername(String username);
    String loing(LoginDto loginDto);

}
