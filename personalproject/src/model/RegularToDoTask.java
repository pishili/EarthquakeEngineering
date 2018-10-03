package model;

import java.util.Date;

public class RegularToDoTask extends Item {

    private String category;
    private Boolean isDone;
    private Importance importance;


    public RegularToDoTask(String title, Importance importance, Date dueDate) {
        super.setTitle(title);
        super.setTitle(title);
        this.isDone = false;
        this.importance = importance;

    }

    @Override
    public void setDueDate(Date date){
        System.out.println("Regular Item has extended Due Date");
        super.setDueDate(dueDate);
    }

    @Override
    public Date getDueDate(Date date){
        System.out.println("What is the Due Date?");
        return super.getDueDate(dueDate);
    }

    public void setPriority(Importance priority) { this.importance = priority; }

    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }

    public Boolean getIsDone() {
        return this.isDone;
    }

    public Importance getPriority() {
        return this.importance;
    }

    public String toString(){
        return "Task title: " + title + ", Status: " + isDone;
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

