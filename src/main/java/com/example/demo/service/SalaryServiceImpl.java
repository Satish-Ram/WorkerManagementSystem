package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Attendance;
import com.example.demo.entity.Salary;
import com.example.demo.entity.Worker;
import com.example.demo.repository.AttendanceRepository;
import com.example.demo.repository.SalaryRepository;
import com.example.demo.repository.WorkerRepository;
@Service
public class SalaryServiceImpl implements SalaryService{
	
	private final SalaryRepository salaryRepository;
	private final AttendanceRepository attendanceRepository;
	private final WorkerRepository workerRepository;
	
	public SalaryServiceImpl(SalaryRepository salaryRepository,AttendanceRepository attendanceRepository,WorkerRepository workerRepository) {
		this.salaryRepository=salaryRepository;
		this.attendanceRepository=attendanceRepository;
		this.workerRepository=workerRepository;
	}

	@Override
	public Salary calculateSalary(Long workerId, String month) {
		Worker worker=workerRepository.findById(workerId).orElseThrow(()->new RuntimeException("Worker Not Found"));
		List<Attendance> attendanceList=attendanceRepository.findByWorkerWorkerId(workerId);
		long presentDays=attendanceList.stream().filter(a->a.getStatus().equalsIgnoreCase("Present")).count();
		double salaryAmount=presentDays*worker.getDailyWage();
		Salary salary=new Salary();
		salary.setMonth(month);
		salary.setPresentDays((int) presentDays);
		salary.setTotalSalary(salaryAmount);
		salary.setWorker(worker);
		return salaryRepository.save(salary);
	}

	@Override
	public List<Salary> getSalaryByWorker(Long workerId) {
		return salaryRepository.findByWorkerWorkerId(workerId);
	}

}
