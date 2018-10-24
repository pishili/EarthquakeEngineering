package model;

import java.util.ArrayList;
import java.util.Date;

public class ToDoList {
    private String name;
    private String title;
    private String status;
    private Date dueDate;
    RegularToDoTask regularTask;
    UrgentTask urgentTask;
    private ArrayList<RegularToDoTask> regulartasks;
    private ArrayList<UrgentTask> urgenttasks ;


    public ToDoList() {
        this.title = title;
        regulartasks= new ArrayList<>();
        urgenttasks = new ArrayList<>();
    }

    public
    ToDoList(String my_tasks) {
        this.title = title;
        regulartasks= new ArrayList<>();
        urgenttasks = new ArrayList<>();
    }

    public void addRegularTask(RegularToDoTask task) {
        regulartasks.add(task);
    }

    public void addUrgentTask(UrgentTask task) {
        urgenttasks.add(task);
    }

    public void removeRegTask(RegularToDoTask task) {
        regulartasks.remove(task);
    }

    public void removeUrgTask(UrgentTask task) {
        urgenttasks.remove(task);
    }

//    public ArrayList<RegularToDoTask> getRegTasks() {
//        return getRegTasks(regularTask);
//    }

    public ArrayList<RegularToDoTask> getRegTasks() {
        return regulartasks;
    }

    public void setName(){
        this.name = name;
    }

    public boolean getStatus(){
        // Todo
        return false;
    }

    public void dueDate(){
        this.dueDate = dueDate;
//        Date date1 = sdf.parse("20012-10-4 10:15:25");
    }

    @Override
    public String toString() {
        String result = "ToDoList Title: " + name + "\n";
        result += urgenttasks.toString();
        result += regulartasks.toString();
        return result;
    }
}
