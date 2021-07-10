package com.cognizant.sports.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.sports.model.extra.Feedback;
import com.cognizant.sports.service.FeedbackService;

@RestController
@RequestMapping("/feedback")
@CrossOrigin("*")
public class FeedbackController {
	private static final Logger logger=LogManager.getLogger(FeedbackController.class);
	
	@Autowired
    private FeedbackService feedbackService;

    @PostMapping("/")
    public ResponseEntity<Feedback> addFeedback(@RequestBody Feedback feedback) throws Exception{
    	Feedback f1=this.feedbackService.addFeedback(feedback);
    	logger.info("add Feedback");
    	return ResponseEntity.ok(f1);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAll() {
    	logger.info("get all Feedback");
    	return ResponseEntity.ok(this.feedbackService.getAllFeedback());
    }

}
