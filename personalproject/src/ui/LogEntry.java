package ui;

import model.RegularToDoTask;

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
    ArrayList<RegularToDoTask> tasks = new ArrayList<>();
    String result = null;

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void addTask(RegularToDoTask task) {
        tasks.add(task);
    }

    public void removeTask(RegularToDoTask task) {
        tasks.remove(task);
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void printItems(){
        for (RegularToDoTask task: tasks){
            String title = task.getTitle();
        }
    }

    public void addOperand(RegularToDoTask first) {
    }

    public void setResult(List<String> results) {
    }
}
