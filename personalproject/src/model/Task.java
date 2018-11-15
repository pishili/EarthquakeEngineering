package model;

import java.util.Date;
import java.util.Objects;

public class Task implements ToDos, Prioritizable {
    protected String title;
    protected Long id;
    protected Date dueDate;
    protected Boolean iscomplete;
    protected Priority priority;
    private ToDoList toDoList;

    public Task(){
        this.iscomplete = false;
    }

    public Task(String title, Priority priority, Date dueDate) {
        this.title = title;
        this.priority = priority;
        this.dueDate = dueDate;
        this.iscomplete = false;
    }

    public void setTitle(String title, Date mydueDate) {
        System.out.println("Print the title!");
        this.title = title;
        this.dueDate = mydueDate;
    }

    public
    ToDoList getToDoList() {
        return this.toDoList;
    }

    public void setToDoList(ToDoList toDoList) {
        this.toDoList = toDoList;
    }

    @Override
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getTitle() {
        return this.title;
    }

    public
    Priority getPriority() {
        return this.priority;
    }

    public void setDueDate(Date dued){
        this.dueDate = dued;
    }

    public Date getDueDate(Date dueDate) {
        return this.dueDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(title, task.title) &&
                Objects.equals(id, task.id) &&
                priority == task.priority;
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, id, priority);
    }

    public Boolean isDone() {
        return this.iscomplete;
    }

    public void setIsDone(Boolean isDone) {
        this.iscomplete = isDone;
    }

    public Boolean getIsDone() {
        return this.iscomplete;
    }
}
