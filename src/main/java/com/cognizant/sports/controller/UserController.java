package com.cognizant.sports.controller;

import org.apache.coyote.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.cognizant.sports.helper.UserFoundException;
import com.cognizant.sports.helper.UserNotFoundException;
import com.cognizant.sports.model.Role;
import com.cognizant.sports.model.User;
import com.cognizant.sports.model.UserRole;
import com.cognizant.sports.model.extra.Event;
import com.cognizant.sports.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	private static final Logger logger=LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    //creating user
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {
    	logger.info("start");

        user.setProfile("default.png");
        //encoding password with bcryptpasswordencoder

        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

        Set<UserRole> roles = new HashSet<>();

        Role role = new Role();
        role.setRoleId(45L);
        role.setRoleName("PLAYER");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        roles.add(userRole);

        logger.info("end");
        return this.userService.createUser(user, roles);

    }
    
    @PostMapping("/trainer-add")
    public User createUser2(@RequestBody User user) throws Exception {
    	logger.info("start");

        Set<UserRole> roles = new HashSet<>();
        Role role = new Role();
        role.setRoleId(2L);
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        role.setRoleName("TRAINER");
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        roles.add(userRole);
        logger.info("end");
        return this.userService.createUser(user, roles);
    }
    
 
    
    @RequestMapping(value="/all",method=RequestMethod.GET)
    public Set<User> getAllUser() {
        return this.userService.getAllUser();
    }
  
    
    //only players
    @RequestMapping(value="/player",method=RequestMethod.GET)
    public  ResponseEntity<?> getAllUserofType() {
    	logger.info("get players");
        return  ResponseEntity.ok(this.userService.getAllUserofType());
    }

    //only trainers
    @RequestMapping(value="/trainer",method=RequestMethod.GET)
    public  ResponseEntity<?> getAllUserofTrainer() {
    	logger.info("get trainers");
        return  ResponseEntity.ok(this.userService.getAllUserofTrainer());
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) {
    	logger.info("username");
        return this.userService.getUser(username);
    }

    //delete the user by id
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        this.userService.deleteUser(userId);
    }


    @PutMapping(value="/update")
    public ResponseEntity<User> update(@RequestBody User user) {
    	logger.info("update");
        return ResponseEntity.ok(this.userService.updateUser(user));
    }

    @ExceptionHandler(UserFoundException.class) 
    public ResponseEntity<?> exceptionHandler(UserFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }


}
