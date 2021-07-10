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

import com.cognizant.sports.model.extra.PlayerAttendance;
import com.cognizant.sports.service.PlayerAttendanceService;

@RestController
@RequestMapping("/playerAttendance")
@CrossOrigin("*")
public class PlayerAttendanceController {
	private static final Logger logger=LogManager.getLogger(PlayerAttendanceController.class);
	
	@Autowired
    private PlayerAttendanceService playerAttendanceService;

    @PostMapping("/")
    public ResponseEntity<PlayerAttendance> addPlayerAttendance(@RequestBody PlayerAttendance playerAttendance) throws Exception{
    	PlayerAttendance f1=this.playerAttendanceService.addPlayerAttendance(playerAttendance);
    	logger.info("add player attendance");
    	return ResponseEntity.ok(f1);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAll() {
    	logger.info("get all player attendance");
    	return ResponseEntity.ok(this.playerAttendanceService.getAllPlayerAttendance());
    }
    

}
