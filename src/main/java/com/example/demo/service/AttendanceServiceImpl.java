package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Attendance;
import com.example.demo.entity.Worker;
import com.example.demo.repository.AttendanceRepository;
import com.example.demo.repository.WorkerRepository;
@Service
public class AttendanceServiceImpl implements AttendanceService{
	
	private final AttendanceRepository attendanceRepository;
	private final WorkerRepository workerRepository;
	
	public AttendanceServiceImpl(AttendanceRepository attendanceRepository,WorkerRepository workerRepository) {
		this.attendanceRepository=attendanceRepository;
		this.workerRepository=workerRepository;
	}

	@Override
	public Attendance markAttendance(Long workerId, Attendance attendance) {
		Worker worker=workerRepository.findById(workerId).orElseThrow(()->new RuntimeException("Worker Not Found"));
		attendance.setWorker(worker);
		return attendanceRepository.save(attendance);
	}

	@Override
	public List<Attendance> getAttendanceByWorker(Long workerId) {
		return attendanceRepository.findByWorkerWorkerId(workerId);
	}

}
