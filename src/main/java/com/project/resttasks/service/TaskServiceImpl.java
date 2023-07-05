package com.project.resttasks.service;

import com.project.resttasks.entity.Task;
import com.project.resttasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;
    @Override
    public List<Task> listAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task findTaskId(Integer id) {
        return taskRepository.findById(id).get();
    }

    @Override
    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void deleteTask(Integer id) {
        taskRepository.deleteById(id);
    }
}
