package com.cognizant.sports.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cognizant.sports.model.extra.Sponsor;
import com.cognizant.sports.service.SponsorService;

@RestController
@RequestMapping("/sponsor")
@CrossOrigin("*")
public class SponsorController {
	private static final Logger logger=LogManager.getLogger(SponsorController.class);

    @Autowired
    private SponsorService sponsorService;

    //add Sponsor
    @PostMapping("/")
    public ResponseEntity<Sponsor> addSponsor(@RequestBody Sponsor sponsor) {
        Sponsor sponsor1 = this.sponsorService.addSponsor(sponsor);
        logger.info("add sponsor");
        return ResponseEntity.ok(sponsor1);
    }

    //get Sponsor
    @GetMapping("/{SponsorId}")
    public Sponsor getSponsor(@PathVariable("SponsorId") Long SponsorId) {
    	logger.info("sponsorId");
        return this.sponsorService.getSponsor(SponsorId);
    }

    //get all sponsors
    @GetMapping("/")
    public ResponseEntity<?> getAllSponsors() {
    	logger.info("get all sponsors");
        return ResponseEntity.ok(this.sponsorService.getAllSponsors());
    }

    //update Sponsor
    @PutMapping("/")
    public Sponsor updateSponsor(@RequestBody Sponsor sponsor) {
    	logger.info("update sponsor");
        return this.sponsorService.updateSponsor(sponsor);
    }

    //delete Sponsor
    @DeleteMapping("/{SponsorId}")
    public void deleteSponsor(@PathVariable("SponsorId") Long SponsorId) {
    	logger.info("delete sponsor");
        this.sponsorService.deleteSponsor(SponsorId);
    }

}
