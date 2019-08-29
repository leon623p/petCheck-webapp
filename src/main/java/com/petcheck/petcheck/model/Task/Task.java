package com.petcheck.petcheck.model.Task;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.LinkedList;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String taskname;
    private String memo;
    private boolean iseverday = true;
    private boolean repeatsMonday = false;
    private boolean repeatsTuesday = false;
    private boolean repeatsWednesday = false;
    private boolean repeatsThursday = false;
    private boolean repeatsFriday = false;
    private boolean repeatsSaturday = false;

    public boolean isRepeatsMonday() {
        return repeatsMonday;
    }

    public void setRepeatsMonday(boolean repeatsMonday) {
        this.repeatsMonday = repeatsMonday;
    }

    public boolean isRepeatsTuesday() {
        return repeatsTuesday;
    }

    public void setRepeatsTuesday(boolean repeatsTuesday) {
        this.repeatsTuesday = repeatsTuesday;
    }

    public boolean isRepeatsWednesday() {
        return repeatsWednesday;
    }

    public void setRepeatsWednesday(boolean repeatsWednesday) {
        this.repeatsWednesday = repeatsWednesday;
    }

    public boolean isRepeatsThursday() {
        return repeatsThursday;
    }

    public void setRepeatsThursday(boolean repeatsThursday) {
        this.repeatsThursday = repeatsThursday;
    }

    public boolean isRepeatsFriday() {
        return repeatsFriday;
    }

    public void setRepeatsFriday(boolean repeatsFriday) {
        this.repeatsFriday = repeatsFriday;
    }

    public boolean isRepeatsSaturday() {
        return repeatsSaturday;
    }

    public void setRepeatsSaturday(boolean repeatsSaturday) {
        this.repeatsSaturday = repeatsSaturday;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;


    }


    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Task() {
    }

    public boolean isIseverday() {
        return iseverday;
    }

    public void setIseverday(boolean iseverday) {
        this.iseverday = iseverday;
    }

    public Task(String task, String memo) {
        this.taskname = task;
        this.memo = memo;


    }

    public String getTaskname() {
        return taskname;
    }

    public Task(String task) {
        this.taskname = task;


    }


}
