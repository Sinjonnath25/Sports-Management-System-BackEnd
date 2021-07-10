package com.cognizant.sports.service.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.sports.model.extra.Feedback;
import com.cognizant.sports.repo.FeedbackRepository;
import com.cognizant.sports.service.FeedbackService;
@Service
public class FeedbackServiceImpl implements FeedbackService{
	

	@Autowired
	private FeedbackRepository feedbackRepository;
	
	@Override
	public Feedback addFeedback(Feedback feedback) throws Exception {
		Feedback local=this.feedbackRepository.findByPlayerNameAndTrainerName(feedback.getPlayerName(), feedback.getTrainerName());
		if(local!=null) {
			System.out.println("Feedback already submitted");
			throw new Exception("Feedback already submitted");
	}else {
	
		local=this.feedbackRepository.save(feedback);
	}
		return local;
	}
	@Override
	public Set<Feedback> getAllFeedback() {
		return new LinkedHashSet<>(this.feedbackRepository.findAll());
	}
    
	

}
