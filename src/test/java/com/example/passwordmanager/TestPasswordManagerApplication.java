package com.example.passwordmanager;

import org.springframework.boot.SpringApplication;

public class TestPasswordManagerApplication {

    public static void main(String[] args) {
        SpringApplication.from(PasswordManagerApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
