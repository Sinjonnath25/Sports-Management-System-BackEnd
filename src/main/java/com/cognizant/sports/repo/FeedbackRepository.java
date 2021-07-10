package com.cognizant.sports.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.sports.model.extra.Feedback;
import com.cognizant.sports.model.extra.FeedbackPKId;

public interface FeedbackRepository extends JpaRepository<Feedback,FeedbackPKId>{

	public Feedback findByPlayerNameAndTrainerName(String playerName,String trainerName);
}
