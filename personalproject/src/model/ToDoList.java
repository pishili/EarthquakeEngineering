package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ToDoList extends AbstractItem {
    private String name;
    private String status;
    private Date dueDate;
    private ArrayList<ToDoTask> tasks = new ArrayList<>() ;


    public ToDoList(String name) {
        this.name = name;
    }

    public void addTask(ToDoTask task) {
        tasks.add(task);
    }

    public void removeTask(ToDoTask task) {
        tasks.remove(task);
    }

    public List<ToDoTask> getTasks() {
        return tasks;
    }

    public void setName(){
        this.name = name;
    }

    public boolean getStatus(){
        return this.status;
    }

    public void dueDate(){
        this.dueDate = dueDate;
//        Date date1 = sdf.parse("20012-10-4 10:15:25");
    }

    @Override
    public String toString() {
        String result = "ToDoList Title: " + name + "\n";
        result += tasks.toString();
        return result;
    }
}
