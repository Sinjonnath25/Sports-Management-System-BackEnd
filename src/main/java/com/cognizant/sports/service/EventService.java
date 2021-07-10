package com.cognizant.sports.service;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.cognizant.sports.model.extra.Event;

public interface EventService {

	public Event addEvent(Event event);

	Event updateEvent(Event event);

	Set<Event> getEventzes();

	Event getEvent(Long qid);

	void deleteEvent(Long qid);

	//List<Event> getEventzesOfCategory(Category category);

	List<Event> getActiveEvents();
	

}
