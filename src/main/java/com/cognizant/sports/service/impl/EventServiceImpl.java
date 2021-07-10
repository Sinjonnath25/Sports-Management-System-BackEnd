package com.cognizant.sports.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.sports.model.extra.Event;
import com.cognizant.sports.repo.EventRepository;
import com.cognizant.sports.service.EventService;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event addEvent(Event event) {
        return this.eventRepository.save(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return this.eventRepository.save(event);
    }

    @Override
    public Set<Event> getEventzes() {
        return new HashSet<>(this.eventRepository.findAll());
    }

    @Override
    public Event getEvent(Long eventId) {
        return this.eventRepository.findById(eventId).get();
    }

    @Override
    public void deleteEvent(Long eventId) {
        this.eventRepository.deleteById(eventId);
    }

   /* @Override
    public List<Event> getEventzesOfCategory(Category category) {
        return this.eventRepository.findBycategory(category);
    }*/


    //get active eventzes

    @Override
    public List<Event> getActiveEvents() {
        return this.eventRepository.findByActive(true);
    }

    /*@Override
    public List<Event> getActiveEventzesOfCategory(Category c) {
        return this.eventRepository.findByCategoryAndActive(c, true);
    }*/

}
