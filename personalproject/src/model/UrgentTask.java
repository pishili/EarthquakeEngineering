package model;

import java.util.Date;

public class UrgentTask extends Item {

    private String urgentImportance;
    private Long id;
    private String category;
    private Boolean isDone;
    private RegularToDoTask.Importance importance;
    private Date dueDate;

    public UrgentTask(String title, RegularToDoTask.Importance importance, Date dueDate, String urgentImportance) {
        super.setTitle(title);
        super.setTitle(title);
        this.isDone = false;
        this.importance = importance;
        this.dueDate = dueDate;
        this.urgentImportance = urgentImportance;
    }

    @Override
    public void setDueDate(Date date){
        System.out.println("Urgent Item has NO extended Due Date");
        super.setDueDate(dueDate);
    }

    @Override
    public Date getDueDate(Date date){
        System.out.println("What is the Due Date that makes you so nervous about item?");
        return super.getDueDate(dueDate);
    }

    public String getImportance(String urgentImportance){
//        System.out.println("This task should be completed by Tomorrow");
        return urgentImportance + "should be completed by tomorrow";
    }
}
