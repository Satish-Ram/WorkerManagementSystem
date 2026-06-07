package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="salary")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Salary {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long salaryId;
	
	private String month;
	private Integer presentDays;
	private Double totalSalary;
	
	@ManyToOne
	@JoinColumn(name="worker_id")
	private Worker worker;

	public Long getSalaryId() {
		return salaryId;
	}

	public void setSalaryId(Long salaryId) {
		this.salaryId = salaryId;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Integer getPresentDays() {
		return presentDays;
	}

	public void setPresentDays(Integer presentDays) {
		this.presentDays = presentDays;
	}

	public Double getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(Double totalSalary) {
		this.totalSalary = totalSalary;
	}

	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}
	
}
