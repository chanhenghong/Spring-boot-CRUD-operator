package com.acleda.crud.repositorty;

import com.acleda.crud.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Integer>, JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}
