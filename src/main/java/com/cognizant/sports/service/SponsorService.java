package com.cognizant.sports.service;

import java.util.Set;

import com.cognizant.sports.model.extra.Sponsor;

public interface SponsorService {

	public Sponsor addSponsor(Sponsor sponsor);

	public Sponsor getSponsor(Long sponsorId);

	public Set<Sponsor> getAllSponsors();

	public Sponsor updateSponsor(Sponsor sponsor);

	public void deleteSponsor(Long sponsorId);
	
}
