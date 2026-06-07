package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Salary;

public interface SalaryService {
	Salary calculateSalary(Long workerId,String month);
	List<Salary> getSalaryByWorker(Long workerId);
}
