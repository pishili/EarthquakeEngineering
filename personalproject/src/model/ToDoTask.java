package model;

import java.util.Date;

public class ToDoTask {
    private String title;
    private Long id;
    private String status;
    private String importance;
    private Date dueDate;

    public ToDoTask(String title, String status, String importance) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.importance = importance;
        this.dueDate = dueDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPriority(String priority) { this.importance = importance; }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public String getTitle() {
        return this.title;
    }

    public String getPriority() {
        return this.importance;
    }

    public String toString(){
        return "Task title: " + title + ", Status: " + status;
    }

    public getDueDate() {
        return this.dueDate;
    }

    public Date setDueDate(Date dued){
        this.dueDate = dued;
    }

    public boolean isDone(Date date) {
        if (this.dueDate.after(date)) {
            status = true;
        } else {
            status = false;
        }
        return status;
    }

}

