package com.acleda.crud.service.impl;

import com.acleda.crud.entity.Role;
import com.acleda.crud.repositorty.RoleRepository;
import com.acleda.crud.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    @Override
    public Optional<Role> findRoleByName(String name) {
        return roleRepository.findByName(name);
    }
}
