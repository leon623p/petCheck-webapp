package com.petcheck.petcheck.controller;
import com.petcheck.petcheck.model.Task.TaskRepository;
import com.petcheck.petcheck.model.Task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
public class taskApiController {

@Autowired
    private TaskService taskService;
    private TaskRepository taskRepository;

    @CrossOrigin
    @GetMapping("/api/tasks")
    public List tasksapiview() {
        String currentuser = SecurityContextHolder.getContext().getAuthentication().getName();
        return taskService.findTasksapi();

    }
    @CrossOrigin
    @GetMapping("/api/completed")
    public void completed(@RequestParam(name = "id") Long id) {
        taskService.Completed(id);
    }



}


