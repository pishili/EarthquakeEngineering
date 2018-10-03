package model;

import java.util.Date;

public class RegularToDoTask extends Item {

    private String category;


    public RegularToDoTask(String title, Importance high, Date dueDate) {
        this.iscomplete = false;
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

    @Override
    public Boolean complete() {
        System.out.println("Is it complete?");
        return super.complete();
    }

    public void setPriority(Importance priority) { this.importance = priority; }

    public void setIsDone(Boolean isDone) {
        this.iscomplete = isDone;
    }

    public Boolean getIsDone() {
        return this.iscomplete;
    }

    public String toString(){
        return "Task title: " + title + ", Status: " + iscomplete;
    }

    public boolean isDone()  {
        return iscomplete;
    }


}

