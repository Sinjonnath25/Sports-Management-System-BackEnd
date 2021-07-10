package com.cognizant.sports.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.sports.model.extra.Sponsor;



public interface SponsorRepository extends JpaRepository<Sponsor, Long>{

}
