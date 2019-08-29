package com.petcheck.petcheck.model.Task;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.LinkedList;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String taskname;
    private String memo;
    private LinkedList<LocalDate> daterange = new LinkedList();
    private boolean iseverday;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public LinkedList<LocalDate> getDaterange() {
        return daterange;
    }

    public void setDaterange(LinkedList<LocalDate> daterange) {
        this.daterange = daterange;
    }

    public boolean hasdate(LocalDate date) {
        boolean hasdate = false;
        for (LocalDate str : daterange) {
            if (date.isEqual(str)) {
                 hasdate=  true;
            }
        }
        return hasdate;
    }


    public void everyXdays(LocalDate start, LocalDate end, int interval, int triplength) {
        this.iseverday = false;
        for (int i = 0; i <= triplength; i++) {
            LocalDate runningdate = start.plusDays(interval);
            if (runningdate.isBefore(end)) {
                daterange.add(runningdate);
            }
        }


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
        this.iseverday = true;

    }

    public String getTaskname() {
        return taskname;
    }

    public Task(String task) {
        this.taskname = task;
        this.iseverday = true;

    }

    public Task(String task, String memo, LocalDate machinedate) {
        this.taskname = task;
        this.memo = memo;
        this.iseverday = false;
        daterange.add(machinedate);
    }




}
