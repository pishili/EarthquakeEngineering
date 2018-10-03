package model;

import java.util.Date;

public abstract class Item implements ToDos {
    String title;
    Long id;
    Date dueDate;
    Boolean iscomplete;

    public Item(){

    }

    public void setTitle(String title) {
        System.out.println("Print the title!");
        this.title = title;
    }

    public String getTitle() {
        return this.title;
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
        }

    }
}
