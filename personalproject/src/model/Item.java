package model;

import java.util.Date;
import java.util.Objects;

public abstract class Item implements ToDos, Prioritizable {
    protected String title;
    protected Long id;
    protected Date dueDate;
    protected Boolean iscomplete;
    protected Importance importance;
    private ToDoList toDoList;

    public Item(){
        this.iscomplete = false;
    }

    public void setTitle(String title, Date mydueDate) {
        System.out.println("Print the title!");
        this.title = title;
        this.dueDate = mydueDate;
    }

    public ToDoList getToDoList() {
        return this.toDoList;
    }

    public void setToDoList(ToDoList toDoList) {
        this.toDoList = toDoList;
    }

    public Importance getPriority() {
        return this.importance;
    }

    public String getTitle() {
        return this.title;
    }

    public Importance getImportance() {
        return this.importance;
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
        Item item = (Item) o;
        return Objects.equals(title, item.title) &&
                Objects.equals(id, item.id) &&
                importance == item.importance;
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, id, importance);
    }

    public Boolean complete(){

        if (iscomplete) {
            return true;
        }return false;

    }
}
