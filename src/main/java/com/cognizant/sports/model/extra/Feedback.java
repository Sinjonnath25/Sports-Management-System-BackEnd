package com.cognizant.sports.model.extra;

import javax.persistence.*;
@Entity
@Table(name="feedback")
@IdClass(FeedbackPKId.class)
public class Feedback {
	
	@Id
	private String playerName;
	@Id
	private String trainerName;
	
	private String rating;
	
	private String comment;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
	
	

}
