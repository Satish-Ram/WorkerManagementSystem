package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Worker;

public interface WorkerService {
	
	Worker saveWorker(Worker worker);
	
	Worker getWorkerById(Long id);
	
	List<Worker> getAllWorkers();
	
	Worker updateWorker(Long id,Worker worker);
	
	void deleteWorker(Long id);

}
