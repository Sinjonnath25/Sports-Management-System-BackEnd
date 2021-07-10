package com.cognizant.sports;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.cognizant.sports.helper.UserFoundException;
import com.cognizant.sports.model.Role;
import com.cognizant.sports.model.User;
import com.cognizant.sports.model.UserRole;
import com.cognizant.sports.service.UserService;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SportsManagementSystemApplication  implements CommandLineRunner{

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    //managing log
    private static final Logger logger=LogManager.getLogger(SportsManagementSystemApplication.class);

    
    public static void main(String[] args) {
        SpringApplication.run(SportsManagementSystemApplication.class, args);
    }
    
    
  //Adding Admin Credentials to database
    @Override
    public void run(String... args) throws Exception {
        try {


          System.out.println("starting code");
//
            User user = new User();

            user.setFirstName("Sinjon");
            user.setLastName("Nath");
            user.setUsername("sinjon25");
            user.setPassword(this.bCryptPasswordEncoder.encode("abc123"));
            user.setEmail("sinjon@gmail.com");
            user.setProfile("default.png");
            user.setPhone("8013896502");

            Role role1 = new Role();
            role1.setRoleId(44L);
            role1.setRoleName("ADMIN");

            Set<UserRole> userRoleSet = new HashSet<>();
            UserRole userRole = new UserRole();

            userRole.setRole(role1);

            userRole.setUser(user);

            userRoleSet.add(userRole);

            User user1 = this.userService.createUser(user, userRoleSet);
            System.out.println(user1.getUsername());


        } catch (UserFoundException e) {
            e.printStackTrace();


        }


    }
}