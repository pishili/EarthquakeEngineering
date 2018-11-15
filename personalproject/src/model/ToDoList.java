package model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ToDoList {
    private String name;
    private String title;
    private String status;
    private Date dueDate;
    private Map<String, Task> tasks = new HashMap<>();

    public ToDoList() {
        this.title = title;
    }

    public ToDoList(String my_tasks) {
        this.title = title;
    }

    public void addTask(Task task) throws TooManyRegularThingsToDo, TooManyUrgentThingsToDo {
        // Throw exception if too many not done tasks
        if (task.getPriority() != Prioritizable.Priority.HIGH && getCountOfNotDoneRegularTasks() >= 5) {
            throw new TooManyRegularThingsToDo();
        }

        if (task.getPriority() == Prioritizable.Priority.HIGH && getCountOfNotDoneUrgentTasks() >= 2) {
            throw new TooManyUrgentThingsToDo();
        }

        if(!tasks.containsKey(task.title)) {
            tasks.put(task.title, task);
            task.setToDoList(this);
        }
    }

    private int getCountOfNotDoneRegularTasks() {
        // Count not done tasks
        int notDoneCount = 0;
        for (Task task: getRegTasks().values()) {
            if (!task.isDone()) {
                notDoneCount++;
            }
        }
        return notDoneCount;
    }

    private int getCountOfNotDoneUrgentTasks() {
        // Count not done tasks
        int notDoneCount = 0;
        for (Task task: getUrgentTasks().values()) {
            if (!task.isDone()) {
                notDoneCount++;
            }
        }
        return notDoneCount;
    }

    public void removeTask(Task task) {
        tasks.remove(task.title);
    }


    public Map<String, Task> getRegTasks() {
        Map<String, Task> regTasks = new HashMap<>();
        for (Map.Entry<String, Task> task : tasks.entrySet()) {
            if (task.getValue().getPriority() != Prioritizable.Priority.HIGH) {
                regTasks.put(task.getKey(), task.getValue());
            }
        }
        return regTasks;
    }

    public Map<String, Task> getUrgentTasks() {
        Map<String, Task> regTasks = new HashMap<>();
        for (Map.Entry<String, Task> task : tasks.entrySet()) {
            if (task.getValue().getPriority() == Prioritizable.Priority.HIGH) {
                regTasks.put(task.getKey(), task.getValue());
            }
        }
        return regTasks;
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
        result += tasks.values().toString();
        return result;
    }
}
