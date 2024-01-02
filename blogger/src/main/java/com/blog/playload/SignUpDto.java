package com.blog.playload;


import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

    @Data
    public class SignUpDto {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private String name;
        private String username;
        private String email;
        private String password;

    }

