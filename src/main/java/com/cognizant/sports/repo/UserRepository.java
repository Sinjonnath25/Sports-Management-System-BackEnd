package com.cognizant.sports.repo;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.sports.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);
    
    public List<User> findAll();
    
    @Query(value="select * from users where type ='Player'",nativeQuery=true)
    public Set<User> findAllofType();

    @Query(value="select * from users where type ='Trainer'",nativeQuery=true)
	public Set<User> findAllofTrainer();
    
    
    
}
