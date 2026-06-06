package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Attendance;

public interface AttendanceService {
	Attendance markAttendance(Long workerId,Attendance attendance);
	
	List<Attendance> getAttendanceByWorker(Long workerId);
}
