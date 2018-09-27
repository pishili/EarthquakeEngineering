package model;

import java.util.Date;

public class ToDoTask {
    private String title;
    private Long id;
    private String category;
    private Boolean isDone;
    private Importance importance;
    private Date dueDate;

    public ToDoTask(String title, Importance importance, Date dueDate) {
        this.title = title;
        this.isDone = false;
        this.importance = importance;
        this.dueDate = dueDate;

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPriority(Importance priority) { this.importance = priority; }

    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }

    public Boolean getIsDone() {
        return this.isDone;
    }

    public String getTitle() {
        return this.title;
    }

    public Importance getPriority() {
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

    public boolean isDone()  {
        return isDone;
    }

    public static enum Importance {
        HIGH,
        MEDIUM,
        LOW
    }

}

