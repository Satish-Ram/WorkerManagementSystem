package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Worker;
import com.example.demo.repository.WorkerRepository;

@Service
public class WorkerServiceImpl implements WorkerService{
	private final WorkerRepository workerRepository;
	
	public WorkerServiceImpl(WorkerRepository workerRepository) {
		this.workerRepository=workerRepository;
	}

	@Override
	public Worker saveWorker(Worker worker) {
		return workerRepository.save(worker);
	}

	@Override
	public Worker getWorkerById(Long id) {
		return workerRepository.findById(id).orElseThrow(()->new RuntimeException("Worker Not Found"));
	}

	@Override
	public List<Worker> getAllWorkers() {
		return workerRepository.findAll();
	}

	@Override
	public Worker updateWorker(Long id, Worker worker) {
		Worker existing=getWorkerById(id);
		existing.setWorkerName(worker.getWorkerName());
		existing.setMobile(worker.getMobile());
		existing.setAddress(worker.getAddress());
		existing.setDailyWage(worker.getDailyWage());
		existing.setSiteName(worker.getSiteName());
		
		return workerRepository.save(existing);
	}

	@Override
	public void deleteWorker(Long id) {
		Worker worker=getWorkerById(id);
		workerRepository.delete(worker);
		
	}
	
	
	
}
