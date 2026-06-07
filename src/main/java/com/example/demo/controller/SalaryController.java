package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Salary;
import com.example.demo.service.SalaryService;

@RestController
@RequestMapping("/api/salary")
@CrossOrigin("*")
public class SalaryController {
	private final SalaryService salaryService;
	
	public SalaryController(SalaryService salaryService) {
		this.salaryService=salaryService;
	}
	
	@PostMapping("/{workerId}/{month}")
	public Salary calculateSalary(@PathVariable Long workerId,@PathVariable String month) {
		return salaryService.calculateSalary(workerId, month);
	}
	
	
	@GetMapping("/{workerId}")
	public List<Salary> getSalary(@PathVariable Long workerId){
		return salaryService.getSalaryByWorker(workerId);
	}
}
