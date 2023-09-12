package com.acleda.crud.config;

import com.acleda.crud.entity.Role;
import com.acleda.crud.entity.User;
import com.acleda.crud.repositorty.RoleRepository;
import com.acleda.crud.repositorty.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Component
public class SetupRoleRunner implements CommandLineRunner {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {
        Role role = new Role();
        role.setId(1);
        role.setName("ADMIN");
        roleRepository.save(role);

        Role role2 = new Role();
        role2.setId(2);
        role2.setName("USER");
        roleRepository.save(role2);

//            Role role1 = roleRepository.findByName("ADMIN");

//        User user2 = new User();
//        user2.setUsername("heng");
//        user2.setPassword("123");
//        user2.setGivenName("Chanheng");
//        user2.setFamilyName("Hong");
//        user2.setEmail("chanheng2002@gmail.com");
//        user2.setStatus(true);
//        user2.setRoles(Collections.singletonList(role1));
//        userRepository.save(user2);

    }
}
