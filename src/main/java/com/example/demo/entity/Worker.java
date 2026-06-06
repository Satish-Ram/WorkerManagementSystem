package com.example.demo.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name="workers")
@NoArgsConstructor
@AllArgsConstructor
public class Worker {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long workerid;
	
	private String workerName;
	private String mobile;
	private String address;
	private Double dailyWage;
	private String siteName;
	private LocalDate joiningDate;
	
	@JsonManagedReference
	@OneToMany(mappedBy="worker",cascade=CascadeType.ALL)
	private List<Attendance> attendances;
	
	public Long getWorkerid() {
		return workerid;
	}
	public void setWorkerid(Long workerid) {
		this.workerid = workerid;
	}
	public String getWorkerName() {
		return workerName;
	}
	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Double getDailyWage() {
		return dailyWage;
	}
	public void setDailyWage(Double dailyWage) {
		this.dailyWage = dailyWage;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public LocalDate getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}
	

}
