package ui;

import model.Task;

import java.util.ArrayList;
import java.util.List;


// If you are making a To Do list application,
// you might make the main interaction loop that asks:
// "what would you like to do
// [1] add a to do list item,
// [2] cross off an item
// [3] show all the items"
public class LogEntry {
    String operation = "";
    ArrayList<Task> tasks = new ArrayList<>();
    String result = null;

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void printItems(){
        for (Task task: tasks){
            String title = task.getTitle();
        }
    }

    public void addOperand(Task first) {
    }

    public void setResult(List<String> results) {
    }
}
