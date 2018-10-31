package model;

import java.util.Date;
import java.util.Objects;

public class UrgentTask extends Item {

    private String urgentImportance;
    private Long id;
    private String category;
    private Date dueDate;
    private ToDoList toDoList;

    public
    UrgentTask(String title, Date dueDate) {
        this.title = title;
        this.dueDate = dueDate;
        importance = Importance.HIGH;
    }

    @Override
    public
    void setDueDate(Date date) {
        System.out.println("Urgent Item has NO extended Due Date");
        super.setDueDate(dueDate);
    }

    @Override
    public
    Date getDueDate(Date date) {
        System.out.println("What is the Due Date that makes you so nervous about item?");
        return super.getDueDate(dueDate);
    }

    @Override
    public
    Boolean complete() {
        System.out.println("Is it complete for Urgent Task?");
        return super.complete();
    }

    public
    boolean isDone() {
        return iscomplete;
    }

    @Override
    public
    void setPriority(Importance priority) {
        // do nothing
    }

    public
    String getImportance(String urgentImportance) {
//        System.out.println("This task should be completed by Tomorrow");
        return urgentImportance + "should be completed by tomorrow";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UrgentTask that = (UrgentTask) o;
        return Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), category);
    }

    public void setToDoList(ToDoList toDoList) {
        this.toDoList = toDoList;
    }
}
