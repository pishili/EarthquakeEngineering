package model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ToDoListRegularTask extends ToDoList {
    private String name;
    private String title;
    private String status;
    private Date dueDate;
    RegularToDoTask regularTask;
    private Map<String, RegularToDoTask> regularTasks = new HashMap<>();
88
    public ToDoListRegularTask(String my_tasks) {
        super();
    }

    public void addRegularTask(RegularToDoTask task) throws TooManyRegularThingsToDo {
        // Throw exception if too many not done tasks
        if (getCountOfNotDoneRegularTasks() >= 5) {
            throw new TooManyRegularThingsToDo();
        }

        if(!regularTasks.containsKey(task.title)) {
            regularTasks.put(task.title, task);
            task.setToDoList(this);
        }
    }

    private int getCountOfNotDoneRegularTasks() {
        // Count not done tasks
        int notDoneCount = 0;
        for (RegularToDoTask task: regularTasks.values()) {
            if (!task.isDone()) {
                notDoneCount++;
            }
        }
        return notDoneCount;
    }

    public void removeRegTask(RegularToDoTask task) {
        regularTasks.remove(task.title);
    }

    public Map<String, RegularToDoTask> getRegTasks() {
        return regularTasks;
    }

    @Override
    public String toString() {
        String result = "ToDoList Title: " + name + "\n";
        result += regularTasks.values().toString();
        return result;
    }
}
