package com.cognizant.sports.service;

import java.util.Set;

import com.cognizant.sports.model.extra.PlayerAttendance;

public interface PlayerAttendanceService {

	PlayerAttendance addPlayerAttendance(PlayerAttendance playerAttendance) throws Exception;

	Set<PlayerAttendance> getAllPlayerAttendance();

}
