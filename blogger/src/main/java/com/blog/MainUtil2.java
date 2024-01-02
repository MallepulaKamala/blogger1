package com.blog;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MainUtil2 {
    public static void main(String[] args){
        BCryptPasswordEncoder passwordEncoer = new BCryptPasswordEncoder();
        System.out.println(passwordEncoer.encode("kamala"));

    }
}
