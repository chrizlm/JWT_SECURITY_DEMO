package com.chris.securitydemo;

import com.chris.securitydemo.models.AppUser;
import com.chris.securitydemo.models.Role;
import com.chris.securitydemo.services.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityDemoApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(AppUserService appUserService){
        return args -> {
            appUserService.saveRole(new Role(null, "ROLE_USER"));
            appUserService.saveRole(new Role(null, "ROLE_MANAGER"));
            appUserService.saveRole(new Role(null, "ROLE_ADMIN"));
            appUserService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));


            appUserService.saveAppUser(new AppUser(null, "John Travolta", "john", "1234", new ArrayList<>()));
            appUserService.saveAppUser(new AppUser(null, "Will Smith", "will", "1234", new ArrayList<>()));
            appUserService.saveAppUser(new AppUser(null, "Jim Carry", "jim", "1234", new ArrayList<>()));
            appUserService.saveAppUser(new AppUser(null, "who is", "who", "1234", new ArrayList<>()));

            appUserService.addRoleToUser("john", "ROLE_USER");
            appUserService.addRoleToUser("john", "ROLE_MANAGER");
            appUserService.addRoleToUser("will", "ROLE_MANAGER");
            appUserService.addRoleToUser("jim", "ROLE_ADMIN");
            appUserService.addRoleToUser("who", "ROLE_SUPER_ADMIN");
            appUserService.addRoleToUser("who","ROLE_ADMIN");
            appUserService.addRoleToUser("who", "ROLE_USER");
        };
    }

}
