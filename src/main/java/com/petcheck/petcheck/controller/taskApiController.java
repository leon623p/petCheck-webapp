package com.petcheck.petcheck.controller;
import com.petcheck.petcheck.model.Task.TaskRepository;
import com.petcheck.petcheck.model.Task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
public class taskApiController {

@Autowired
    private TaskService taskService;
    private TaskRepository taskRepository;


    @GetMapping("/api/tasks")
    public List tasksapiview() {
        return taskService.findTasksapi();

    }


}


