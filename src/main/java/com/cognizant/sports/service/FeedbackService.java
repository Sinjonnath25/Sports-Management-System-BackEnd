package com.cognizant.sports.service;

import java.util.Set;

import com.cognizant.sports.model.extra.Feedback;


public interface FeedbackService {

	Feedback addFeedback(Feedback feedback) throws Exception;

	Set<Feedback> getAllFeedback();

}
