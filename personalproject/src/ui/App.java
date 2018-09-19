package starter;

import model.ToDoList;
import model.ToDoTask;
import ui.LogEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    //    ArrayList<LogEntry> operationLog = new ArrayList<>();
    ToDoList taskarchive = new ToDoList();
    Scanner scanner = new Scanner(System.in);

    public App() {
        String operation = "";
        while (true) {
            LogEntry opEntry = new LogEntry();
            System.out.println("Please select an option");
            operation = scanner.nextLine();
            System.out.println("you selected" + operation);
            String result = null;
            List<String> results = null;
            if (operation.equals("one")) {
                opEntry.setOperation(operation);
                result = one(opEntry);
                opEntry.setResult(result);
            } else if (operation.equals("two")) {
                opEntry.setOperation((operation));
                result = two(opEntry);
                opEntry.setResult(result);
            } else if (operation.equals("three")) {
                opEntry.setOperation((operation));
                results = three(opEntry);
                opEntry.setResult(results);
            }

        }
    }

    private String one(LogEntry logEntry) {
        System.out.println("Please enter your task to be added to your TODO list with its importance and status");
        String tasktitle = scanner.nextLine();
        String importance = scanner.nextLine();
        String status = scanner.nextLine();
        ToDoTask task1 = new ToDoTask(tasktitle, status, importance);
        taskarchive.addTask(task1);
        logEntry.addOperand(task1);
        return tasktitle;
    }

    private String two(LogEntry logEntry) {
        System.out.println("Please enter the title of the task you would like to remove");
        String tasktitle = scanner.nextLine();
        for (ToDoTask item : taskarchive.getTasks()) {
            if (item.getTitle() == tasktitle) {
                taskarchive.removeTask(item);
            }
        }
        return tasktitle;
    }

    private List<String> three(LogEntry logEntry) {
        System.out.println("We will print all your active tasks for you!");
        List<String> list = new ArrayList<>();
        for (ToDoTask item : taskarchive.getTasks()) {
            System.out.println(item.getTitle());
            list.add(item.getTitle());
        }
        return list;
    }

    public static void main(String[] args) {
        new App();
        ToDoTask task;
        ToDoList taskarchive = new ToDoList();
//
//        ArrayList<LogEntry> operationLog = new ArrayList<>();
//        Scanner scanner = new Scanner(System.in);
//        ToDoTask task = new ToDoTask();
//        ToDoList taskarchive = new ToDoList();
//
//        // Create tasks
        ToDoTask t1 = new ToDoTask("First Task", "new", "1");
        ToDoTask t2 = new ToDoTask("Second Task", "pending", "2");
        ToDoTask t3 = new ToDoTask("Third Task", "pending", "1");
        ToDoTask t4 = new ToDoTask("Workout Task", "finished" , "1");

        // Print tasks
        printTask(t1);
        printTask(t2);
        printTask(t3);
        printTask(t4);

         //Create ToDoLists
        ToDoList l1 = new ToDoList("CS Tasks");

         //Add items to list
        l1.addTask(t1);
        l1.addTask(t2);
        l1.addTask(t3);

        // Print list
        printList(l1);
    }

    private static void printTask(ToDoTask task) {
        System.out.println("Called printTask");
        System.out.println(task);
    }

    // add a toDo list item
    private static void printList(ToDoList list) {
        System.out.println("Called printList");
        System.out.println(list);
    }

}
