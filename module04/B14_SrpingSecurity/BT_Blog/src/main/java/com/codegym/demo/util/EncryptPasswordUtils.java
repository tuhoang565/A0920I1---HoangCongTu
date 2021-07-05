package com.codegym.demo.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptPasswordUtils {
    public static String EncryptPasswordUtils(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

//    public static void main(String[] args) {
//        System.out.println("pass 123456 ma hoa: " + EncryptPasswordUtils("123456"));
//        //$2a$10$6bLybBynBGo2gu/JOOWRiumA4oadRaqUD2zU9uvUtdc6F/m8MqlyS
//    }
}
