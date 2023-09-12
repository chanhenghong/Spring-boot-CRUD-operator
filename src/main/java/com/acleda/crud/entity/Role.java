package com.acleda.crud.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Entity
@Data
@Setter
@Getter
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    private Integer id;
    private String name;

    @Override
    public String getAuthority() {
        return "ROLE_" + this.name;
    }
}
