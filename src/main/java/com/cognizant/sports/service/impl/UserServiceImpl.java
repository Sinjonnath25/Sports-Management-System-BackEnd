package com.cognizant.sports.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.cognizant.sports.helper.UserFoundException;
import com.cognizant.sports.helper.UserNotFoundException;
import com.cognizant.sports.model.Role;
import com.cognizant.sports.model.User;
import com.cognizant.sports.model.UserRole;
import com.cognizant.sports.repo.RoleRepository;
import com.cognizant.sports.repo.UserRepository;
import com.cognizant.sports.service.UserService;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    //creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {


        User local = this.userRepository.findByUsername(user.getUsername());
        if (local != null) {
            System.out.println("User is already there !!");
            throw new UserFoundException();
        } else {
            //user create
            for (UserRole ur : userRoles) {
                roleRepository.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);

        }

        return local;
    }

    //getting user by username
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }

	@Override
	public User updateUser(User user) {
		
		User existingUser=userRepository.findByUsername(user.getUsername());
		if(existingUser!=null) {
			System.out.println("Get it put");
		}
		existingUser.setEmail(user.getEmail());
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setPhone(user.getPhone());
		
		return this.userRepository.save(existingUser);
	}

	@Override
	public Set<User> getAllUser() {
		return new LinkedHashSet<User>(this.userRepository.findAll());
	}

	@Override
	public Set<User> getAllUserofType() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<User>(this.userRepository.findAllofType());
	}

	@Override
	public Set<User> getAllUserofTrainer() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<User>(this.userRepository.findAllofTrainer());
	}


}
