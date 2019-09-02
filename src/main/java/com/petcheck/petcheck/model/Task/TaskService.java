package com.petcheck.petcheck.model.Task;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private TaskRepository taskRepository;
    private LocalDate todaysDate = LocalDate.now();



    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void saveTask(Task task) {
        taskRepository.save(task);
    }


    public Optional<Task> findTaskById(long id) {
        return taskRepository.findById(id);
    }

    public List<Task> findTasks() {
        Iterable<Task> found = taskRepository.findAll();
        List<Task> taskslist = new ArrayList<>();
        for (Task task : found) {
            taskslist.add(task);

        }
        return taskslist;
    }

    public List<Task> findtodaysTask(String currentuser) {
        String weekday = todaysDate.getDayOfWeek().toString();
        Iterable<Task> found = taskRepository.findAll();
        List<Task> taskslist = new ArrayList<>();
        for (Task task : found) {
            taskslist.add(task);
        }

        List<Task> todaystasklist = taskslist.stream()
                .filter(w ->  w.getTaskowner().equals(currentuser) & w.isIseverday() || w.isdayofweek(weekday) )
                .collect(Collectors.toList());
//|| w.hasdate(LocalDate.now()) == true)
        //

        return todaystasklist;

    }
}
