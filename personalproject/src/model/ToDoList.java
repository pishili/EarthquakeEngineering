package model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class ToDoList {
    private String name;
    private String title;
    private String status;
    private Date dueDate;
//    RegularToDoTask regularTask;
//    UrgentTask urgentTask;
//    private Set<RegularToDoTask> regulartasks;
//    private Set<UrgentTask> urgenttasks ;
//    private Map<String, RegularToDoTask> regularTasks = new HashMap<>();
//    private Map<String, UrgentTask> urgentTasks = new HashMap<>();

    public ToDoList() {
        this.title = title;
    }

    public ToDoList(String my_tasks) {
        this.title = title;
    }

    public void setName(){
        this.name = name;
    }

    public boolean getStatus(){ return status; }

    public void dueDate() {
        this.dueDate = dueDate;
//        Date date1 = sdf.parse("20012-10-4 10:15:25");
    }

//    @Override
//    public String toString() {
//        String result = "ToDoList Title: " + name + "\n";
//        result += urgentTasks.values().toString();
//        result += regularTasks.values().toString();
//        return result;
//    }

//    public void addRegularTask(RegularToDoTask task) throws TooManyRegularThingsToDo {
//        // Throw exception if too many not done tasks
//        if (getCountOfNotDoneRegularTasks() >= 5) {
//            throw new TooManyRegularThingsToDo();
//        }
//
//        if(!regularTasks.containsKey(task.title)) {
//            regularTasks.put(task.title, task);
//            task.setToDoList(this);
//        }
//    }

//    public void addUrgentTask(UrgentTask task) throws TooManyUrgentThingsToDo {
//        // Throw exception if too many not done tasks
//        if(getCountOfNotDoneUrgentTasks() >= 2) {
//            throw new TooManyUrgentThingsToDo();
//        }
//
//        if(!urgentTasks.containsKey(task.title)) {
//            urgentTasks.put(task.title, task);
//            task.setToDoList(this);
//        }
//    }

//    private int getCountOfNotDoneRegularTasks() {
//        // Count not done tasks
//        int notDoneCount = 0;
//        for (RegularToDoTask task: regularTasks.values()) {
//            if (!task.isDone()) {
//                notDoneCount++;
//            }
//        }
//        return notDoneCount;
//    }

//    private int getCountOfNotDoneUrgentTasks() {
//        // Count not done tasks
//        int notDoneCount = 0;
//        for (UrgentTask task: urgentTasks.values()) {
//            if (!task.isDone()) {
//                notDoneCount++;
//            }
//        }
//        return notDoneCount;
//    }

//    public void removeRegTask(RegularToDoTask task) {
//        regularTasks.remove(task.title);
//    }
//
//    public void removeUrgTask(UrgentTask task) {
//        urgentTasks.remove(task.title);
//    }

//    public ArrayList<RegularToDoTask> getRegTasks() {
//        return getRegTasks(regularTask);
//    }

//    public Map<String, RegularToDoTask> getRegTasks() {
//        return regularTasks;
//    }
//    public Map<String, UrgentTask> getUrgTasks() { return urgentTasks; }
}
