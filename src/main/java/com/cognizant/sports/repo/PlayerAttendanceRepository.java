package com.cognizant.sports.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.sports.model.extra.PlayerAttendance;
import com.cognizant.sports.model.extra.PlayerAttendancePKId;

public interface PlayerAttendanceRepository extends JpaRepository<PlayerAttendance,PlayerAttendancePKId>{

    public PlayerAttendance findByPlayerNameAndDate(String playerName,String date);
}
