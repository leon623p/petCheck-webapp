package com.petcheck.petcheck.controller;


import com.petcheck.petcheck.model.Task.Task;
import com.petcheck.petcheck.model.Task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
                    .orElseThrow(() -> new EntityNotFoundException("Could not find task" + id));
        }
        model.addAttribute("task", task);


        return "task";
    }

    @PostMapping("/task")
    public String saveTask(@ModelAttribute Task task, Model model) {
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        task.setTaskowner(user);
        taskService.saveTask(task);
        model.addAttribute("tasks", taskService.findTasks(user));


        return "tasks";
    }

    @GetMapping("/tasks")
    public String tasksview(Model model) {
        String currentuser = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("tasks", taskService.findTasks(currentuser));
        return "tasks";
    }

    @GetMapping("/todaystasks")
    public String todaystasklist(Model model) {
       String currentuser = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("tasks", taskService.findtodaysTask(currentuser));
        return "todaystasks";
    }
    @DeleteMapping("/task")
    public String deleteTask(@RequestParam(name="id")Long id, Model model) {
        taskService.deleteTask(id);
        model.addAttribute("deleted", id);
        return "redirect:/tasks";
    }

    @GetMapping("/newday")
    public String newday(){
        String currentuser = SecurityContextHolder.getContext().getAuthentication().getName();
        taskService.newday(currentuser);
        return "redirect:/todaystasks";
    }

    @GetMapping("/completed")
    public String completed(@RequestParam(name="id")Long id, Model model){
        taskService.Completed(id);
        model.addAttribute("completed", id);
        return "redirect:/todaystasks";
    }


}
