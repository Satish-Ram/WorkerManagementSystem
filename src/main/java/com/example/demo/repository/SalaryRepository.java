package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Salary;

public interface SalaryRepository extends JpaRepository<Salary,Long>{
	List<Salary> findByWorkerWorkerId(Long workerId);
}
