package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.WorkerDTO;
import com.example.demo.dto.WorkerMapper;
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
	public WorkerDTO getWorker(@PathVariable Long id) {
		Worker worker=workerService.getWorkerById(id);
		return WorkerMapper.toDTO(worker);
	}
	
	@GetMapping
	public List<WorkerDTO> getAllWorkers(){
		return workerService.getAllWorkers().stream().map(WorkerMapper::toDTO).toList();
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
