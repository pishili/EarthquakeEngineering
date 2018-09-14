package models;

import java.util.ArrayList;

public class ToDoList {
    private String name;
    private ArrayList<ToDoTask> tasks = new ArrayList<>();


    public ToDoList(String name) {
        this.name = name;
    }

    public void addTask(ToDoTask task) {
        tasks.add(task);
    }

    public void removeTask(ToDoTask task) {
        tasks.remove(task);
    }

    @Override
    public String toString() {
        String result = "ToDoList Title: " + name + "\n";
        result += tasks.toString();
        return result;
    }
}
