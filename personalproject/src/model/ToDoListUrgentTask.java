package model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ToDoListUrgentTask extends ToDoList {
    private String name;
    private String title;
    private String status;
    private Date dueDate;
    UrgentTask urgentTask;

    private Map<String, UrgentTask> urgentTasks = new HashMap<>();

    public ToDoListUrgentTask(String my_tasks) {
        this.title = title;
    }

    public void addUrgentTask(UrgentTask task) throws TooManyUrgentThingsToDo {
        // Throw exception if too many not done tasks
        if(getCountOfNotDoneUrgentTasks() >= 2) {
            throw new TooManyUrgentThingsToDo();
        }

        if(!urgentTasks.containsKey(task.title)) {
            urgentTasks.put(task.title, task);
            task.setToDoList(this);
        }
    }

    @Override
    public String toString() {
        String result = "ToDoList Title: " + name + "\n";
        result += urgentTasks.values().toString();
        return result;
    }
}
