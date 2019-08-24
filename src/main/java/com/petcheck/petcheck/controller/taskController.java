package com.petcheck.petcheck.controller;


import com.petcheck.petcheck.model.Task.Task;
import com.petcheck.petcheck.model.Task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityNotFoundException;

@Controller
public class taskController {
    private TaskService taskService;

    @Autowired
    public taskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/task")
    public String task(@RequestParam(required = false, name = "id") Long id, Model model) {
        Task task;
        if (id == null) {
            task = new Task();
        } else {
            task = taskService.findTaskById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Could not find cinema " + id));
        }
        model.addAttribute("task", task);

        return "task";
    }
    @PostMapping("/task")
    public String saveTask(@ModelAttribute Task task, Model model) {
        taskService.saveTask(task);
        model.addAttribute("tasks", taskService.getTasks());
        return "tasks";
    }
}
