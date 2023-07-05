package com.project.resttasks.service;

import com.project.resttasks.entity.Task;

import java.util.List;

public interface TaskService {

    public List<Task>listAll();
    public Task findTaskId(Integer id);
    public void saveTask(Task task);
    public void deleteTask(Integer id);
}
