package com.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Data
    @Entity
    @NoArgsConstructor
    @AllArgsConstructor
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private String name;
        private String email;
        private String username;
        private String password;
        @ManyToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
        @JoinTable(
                name="User_Roles",
                joinColumns =@JoinColumn(name="User_Id",referencedColumnName = "Id"),
                inverseJoinColumns = @JoinColumn(name="Roles_Id",referencedColumnName = "Id")
        )
        private Set<Roles> roles;
    }

