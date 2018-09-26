package model;

import java.util.Date;

public class ToDoTask {
    private String title;
    private Long id;
    private Boolean isDone;
    private String importance;
    private Date dueDate;

    public ToDoTask(String title, String importance, Date dueDate) {
        this.id = id;
        this.title = title;
        this.isDone = false;
        this.importance = importance;
        this.dueDate = dueDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPriority(String priority) { this.importance = priority; }

    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }

    public Boolean getIsDone() {
        return this.isDone;
    }

    public String getTitle() {
        return this.title;
    }

    public String getPriority() {
        return this.importance;
    }

    public String toString(){
        return "Task title: " + title + ", Status: " + isDone;
    }

    public Date getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(Date dued){
        this.dueDate = dued;
    }

    public boolean isDone() {
        return isDone;
    }

}

