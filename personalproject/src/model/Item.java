package model;

import java.util.Date;

public abstract class Item implements ToDos, Prioritizable {
    protected String title;
    protected Long id;
    protected Date dueDate;
    protected Boolean iscomplete;
    protected Importance importance;

    public Item(){
        this.iscomplete = true;

    }

    public void setTitle(String title, Date mydueDate) {
        System.out.println("Print the title!");
        this.title = title;
        this.dueDate = mydueDate;

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

    public Boolean complete(){
        if (iscomplete) {
            return true;
        }return false;

    }

}
