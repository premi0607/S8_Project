package net.javaguides.springbootbackend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springbootbackend.exception.ResourceNotFoundException;
import net.javaguides.springbootbackend.model.Task;
import net.javaguides.springbootbackend.repository.TaskRepository;

@RestController
@RequestMapping("/api/v1/")
public class TaskController {
    
    @Autowired
    private TaskRepository taskRepository;

    @CrossOrigin(origins = "http://localhost:4200")    
    @GetMapping("/tasks")
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task task){
        return taskRepository.save(task);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/tasks/{id}")  
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
        Task task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:"+ id));
        return ResponseEntity.ok(task);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails){
        Task task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:"+ id));
        task.setTaskHolder(taskDetails.getTaskHolder());
        task.setTaskName(taskDetails.getTaskName());
        task.setTaskStatus(taskDetails.getTaskStatus());
        task.setTaskDate(taskDetails.getTaskDate());

        Task updatedTask = taskRepository.save(task);
        return ResponseEntity.ok(updatedTask);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteTask(@PathVariable Long id){
        Task task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:"+ id));
        taskRepository.delete(task);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);

    }







}
 