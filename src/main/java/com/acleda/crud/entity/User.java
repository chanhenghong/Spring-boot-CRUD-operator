package com.acleda.crud.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String uuid;
    private String username;
    private String email;
    private String familyName;
    private String givenName;
    private LocalDate dob;
    private String gender;
    private String phone;
    private String profile;
    private String biography;
    private String password;
    private String verifiedToken;
    private LocalDateTime tokenExpiry;
    private LocalDateTime createdAt;
    private Boolean status;

    // A User has many roles
//    @ManyToOne
//    @JoinColumn(name = "roles_id")
//    Role roles;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles = new ArrayList<>();
}
