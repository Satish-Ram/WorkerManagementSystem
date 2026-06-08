package com.example.demo.dto;

import com.example.demo.entity.Worker;

public class WorkerMapper {
	public static WorkerDTO toDTO(Worker worker) {
		WorkerDTO dto=new WorkerDTO();
		dto.setWorkerId(worker.getWorkerId());
		dto.setWorkerName(worker.getWorkerName());
		dto.setMobile(worker.getMobile());
		dto.setAddress(worker.getAddress());
		dto.setDailyWage(worker.getDailyWage());
		dto.setSiteName(worker.getSiteName());
		return dto;
	}
}
