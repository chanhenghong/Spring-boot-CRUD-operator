package com.acleda.crud.service;

import com.acleda.crud.entity.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findRoleByName(String name);
}
