package com.petcheck.petcheck.model.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private TaskRepository taskRepository;

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
}
