package com.cognizant.sports.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.sports.model.extra.Event;
import com.cognizant.sports.model.extra.Sponsor;

public interface EventRepository extends JpaRepository<Event,Long>{
	public List<Event> findBysponsor(Sponsor sponsor);

    public List<Event> findByActive(Boolean b);

    //public List<Event> findByCategoryAndActive(Category c, Boolean b);

}
