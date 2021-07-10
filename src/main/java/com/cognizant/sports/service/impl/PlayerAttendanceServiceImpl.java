package com.cognizant.sports.service.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.sports.model.extra.PlayerAttendance;
import com.cognizant.sports.repo.PlayerAttendanceRepository;
import com.cognizant.sports.service.PlayerAttendanceService;
@Service
public class PlayerAttendanceServiceImpl implements PlayerAttendanceService{
    

    @Autowired
    private PlayerAttendanceRepository playerAttendanceRepository;
    
    @Override
    public PlayerAttendance addPlayerAttendance(PlayerAttendance playerAttendance) throws Exception {
        PlayerAttendance local=this.playerAttendanceRepository.findByPlayerNameAndDate(playerAttendance.getPlayerName(), playerAttendance.getDate());
        if(local!=null) {
            System.out.println("Player Attendance already submitted");
            throw new Exception("Player Attendance already submitted");
    }else {
    
        local=this.playerAttendanceRepository.save(playerAttendance);
    }
        return local;
    }
    @Override
    public Set<PlayerAttendance> getAllPlayerAttendance() {
        return new LinkedHashSet<>(this.playerAttendanceRepository.findAll());
    }
      

}
