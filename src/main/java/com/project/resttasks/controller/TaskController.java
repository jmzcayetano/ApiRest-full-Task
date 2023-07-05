package com.project.resttasks.controller;

import com.project.resttasks.entity.Task;
import com.project.resttasks.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public List<Task>listTask(){
        return taskService.listAll();
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> findTaskById(@PathVariable Integer id) {
        try {
            Task task = taskService.findTaskId(id);
            return new ResponseEntity<Task>(task, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/tasks")
    public void save(Task task){
        taskService.saveTask(task);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task>updateTask(@PathVariable Integer id, @RequestBody Task task){
        try {
            Task currentTask = taskService.findTaskId(id);
            currentTask.setUser(task.getUser());
            currentTask.setDescription((task.getDescription()));
            currentTask.setState(task.getState());
            currentTask.setDay(task.getDay());
            taskService.saveTask(currentTask);
            return new ResponseEntity<Task>(HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTaskById(@PathVariable Integer id){
        taskService.deleteTask(id);
    }
}
