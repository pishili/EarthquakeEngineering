package model;

import java.util.Date;

public class UrgentTask extends Item {

    private String urgentImportance;
    private Long id;
    private String category;
    private Boolean isDone;
    private Date dueDate;

    public UrgentTask(String title, Date dueDate) {
        this.isDone = false;
        this.dueDate = dueDate;
        importance = Importance.HIGH;
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

    @Override
    public Boolean complete() {
        System.out.println("Is it complete for Urgent Task?");
        return super.complete();
    }

    @Override
    public void setPriority(Importance priority) {
        // do nothing
    }

    public String getImportance(String urgentImportance){
//        System.out.println("This task should be completed by Tomorrow");
        return urgentImportance + "should be completed by tomorrow";
    }



}
