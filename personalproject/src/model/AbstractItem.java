package model;

import java.util.Date;

public abstract class AbstractItem {
    private String name;
    private boolean status;
    private Date dueDate;

    // constructor: AbstractItem has the given name, status and dueDate
    public AbstractItem() {
        this.name = name;
        this.status = status;
        this.dueDate = dueDate;
    }

    //Effects: Returns name set in constructor
    public String getName() {
        return this.name;
    }

    // EFFECTS: changes the name according to
    // the name pass in the function
    public void setName(String n) {
        this.name = n;
    }

    // Effects: get the status based on what is set in constructor
    public boolean getStatus() {
        return status;
    }

    // Effects: Set the satatus based on true, false passed to the function
    public void setStatus(Boolean s) {
        this.status = s;
    }

    // Effects: Return the date set in constructor
    public Date getDueDate() {
        return this.dueDate;
    }

    // Effects: Setting a new name based on the name passed in the function
    public void setName(Date dued) {
        this.dueDate = dued;
    }

    //REQUIRES: The input format should be Date
    //MODIFIES:modifies this.status
    //EFFECTS: Changes the status value depending on the due date
    // If the due date is passed then the task is Done, otherwise, the task is not completed yet.

    public boolean isDone(Date date) {
        if (this.dueDate.after(date)) {
            status = true;
        } else {
            status = false;
        }
        return status;
    }
}
