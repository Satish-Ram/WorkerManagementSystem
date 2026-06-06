package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Attendance;
import com.example.demo.service.AttendanceService;

@RestController
@RequestMapping("/api/attendance")
@CrossOrigin("*")
public class AttendanceController {
	private final AttendanceService attendanceService;
	
	public AttendanceController(AttendanceService attendanceService) {
		this.attendanceService=attendanceService;
	}
	
	@PostMapping("/{workerId}")
	public Attendance markAttendance(@PathVariable Long workerId,@RequestBody Attendance attendance) {
		return attendanceService.markAttendance(workerId, attendance);
	}
	
	@GetMapping("/{workerId}")
	public List<Attendance> getAttendance(@PathVariable Long workerId){
		return attendanceService.getAttendanceByWorker(workerId);
	}
}
