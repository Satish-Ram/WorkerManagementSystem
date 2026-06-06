package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Worker;
import com.example.demo.service.WorkerService;

@RestController
@RequestMapping("/api/workers")
@CrossOrigin("*")
public class WorkerController {
	private final WorkerService workerService;
	
	public WorkerController(WorkerService workerService) {
		this.workerService=workerService;
	}
	
	@PostMapping
	public Worker addWorker(@RequestBody Worker worker) {
		return workerService.saveWorker(worker);
	}
	
	@GetMapping("/{id}")
	public Worker getWorker(@PathVariable Long id) {
		return workerService.getWorkerById(id);
	}
	
	@GetMapping
	public List<Worker> getAllWorkers(){
		return workerService.getAllWorkers();
	}
	
	@PutMapping("/{id}")
	public Worker updateWorker(@PathVariable Long id,@RequestBody Worker worker) {
		return workerService.updateWorker(id, worker);
	}
	
	@DeleteMapping("/{id}")
	public String deleteWorker(@PathVariable Long id) {
		workerService.deleteWorker(id);
		return "Worker Deleted Successfully";
	}
}
