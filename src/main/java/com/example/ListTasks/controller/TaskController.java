package com.example.ListTasks.controller;

import com.example.ListTasks.model.Tasks;
import com.example.ListTasks.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping()
    public List<Tasks> getAllTasks() {
        return taskService.getAllTasks();
    }
}
