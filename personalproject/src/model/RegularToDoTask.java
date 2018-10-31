package model;

import java.util.Date;
import java.util.Objects;

public class RegularToDoTask extends Item {

    private String category;
    private ToDoList toDoList;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RegularToDoTask that = (RegularToDoTask) o;
        return Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), category);
    }

    public RegularToDoTask(String title, Importance importance, Date dueDate) {
        this.title = title;
        this.importance = importance;
        this.dueDate = dueDate;
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

    public void setToDoList(ToDoList toDoList) {
        this.toDoList = toDoList;
    }

}

