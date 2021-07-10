package com.cognizant.sports.service.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.sports.model.extra.Sponsor;
import com.cognizant.sports.repo.SponsorRepository;
import com.cognizant.sports.service.SponsorService;
@Service
public class SponsorServiceImpl implements SponsorService {
	
	 @Autowired
	  private SponsorRepository sponsorRepository;

	@Override
	public Sponsor addSponsor(Sponsor sponsor) {
		 return this.sponsorRepository.save(sponsor);
	}

	@Override
	public Sponsor getSponsor(Long sponsorId) {
		 return this.sponsorRepository.findById(sponsorId).get();
	}

	@Override
	public Set<Sponsor> getAllSponsors() {
		return new LinkedHashSet<>(this.sponsorRepository.findAll());
	}

	@Override
	public Sponsor updateSponsor(Sponsor sponsor) {
		return this.sponsorRepository.save(sponsor);
	}

	@Override
	public void deleteSponsor(Long sponsorId) {
		Sponsor sponsor = new Sponsor();
		sponsor.setSid(sponsorId);        
		this.sponsorRepository.delete(sponsor);
	}

}
