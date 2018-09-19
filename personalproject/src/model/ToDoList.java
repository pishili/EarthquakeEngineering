package model;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private String name;
    private ArrayList<ToDoTask> tasks = new ArrayList<>();


    public ToDoList(String name) {
        this.name = name;
    }

    public ToDoList() {

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

    @Override
    public String toString() {
        String result = "ToDoList Title: " + name + "\n";
        result += tasks.toString();
        return result;
    }

}
