package com.cognizant.sports.service;

import java.util.List;
import java.util.Set;

import com.cognizant.sports.model.User;
import com.cognizant.sports.model.UserRole;
import com.cognizant.sports.model.extra.Event;

public interface UserService {

    //creating user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    //get user by username
    public User getUser(String username);
    
    

    //delete user by id
    public void deleteUser(Long userId);

	//public User updateUser(User user);

	public Set<User> getAllUser();

	public Set<User> getAllUserofType();

	public Set<User> getAllUserofTrainer();

	public User updateUser(User user);

	//public boolean updateStudent(User user);
    
    
}
