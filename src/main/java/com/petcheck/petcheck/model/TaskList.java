package com.petcheck.petcheck.model;

import com.petcheck.petcheck.model.Task.Task;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskList {
    private LinkedList<Task> tasklist = new LinkedList<Task>();

    private LocalDate todaysDate = LocalDate.now();

    public void addTask(Task addtsk) {
        tasklist.add(addtsk);


    }

    public void removeTask(Task rmvtask) {
        for (Task list : tasklist) {
            if (rmvtask.getTaskname().equals(list.getTaskname())) {
                tasklist.remove(list);

            }
        }

    }


//todo seems to work the task constructors might need some work but yeah
    public List<Task> todaysTask() {
        List<Task> todaystasklist = tasklist.stream()
                .filter(w -> w.isIseverday() == true || w.hasdate(LocalDate.now()) == true)
                .collect(Collectors.toList());


        return todaystasklist;

    }


    //todo print tasks alphabetically/sorting (maybe handled on the frontend/ probably just copy todaystask() but add .sorted

}


//    public void todaysTask() {
//       // TaskList todaystasks = new TaskList();
//        //tested this method can create a new list just gotta look up the clone and or a copy methood
//        for (Task list : tasklist) {
//            if (list.isIseverday() == true) {
//                System.out.println(list.getTaskname());
//            }
//            if (list.hasdate(todaysDate)) {
//                System.out.println(list.getTaskname());
//
//
//            }
//
//        }
//    }


