package com.cognizant.sports.controller;



import org.apache.coyote.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cognizant.sports.model.extra.Event;
import com.cognizant.sports.service.EventService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/event")
public class EventController {
	private static final Logger logger=LogManager.getLogger(EventController.class);
    @Autowired
    private EventService eventService;

    //add event service
    @PostMapping("/")
    public ResponseEntity<Event> add(@RequestBody Event event) {
    	logger.info("add event");
        return ResponseEntity.ok(this.eventService.addEvent(event));
    }

    //update event

    @PutMapping("/")
    public ResponseEntity<Event> update(@RequestBody Event event) {
    	logger.info("update event");
        return ResponseEntity.ok(this.eventService.updateEvent(event));
    }

    //get event
    @GetMapping("/")
    public ResponseEntity<?> eventzes() {
    	logger.info("get event");
        return ResponseEntity.ok(this.eventService.getEventzes());
    }

    //get single event
    @GetMapping("/{qid}")
    public Event event(@PathVariable("qid") Long qid) {
    	logger.info("get single event");
        return this.eventService.getEvent(qid);
    }

    //delete the event
    @DeleteMapping("/{qid}")
    public void delete(@PathVariable("qid") Long qid) {
    	logger.info("delete event");
        this.eventService.deleteEvent(qid);
    }


    //get active eventzes
    @GetMapping("/active")
    public List<Event> getActiveEvents() {
    	logger.info("get active events");
        return this.eventService.getActiveEvents();
    }

  


}

