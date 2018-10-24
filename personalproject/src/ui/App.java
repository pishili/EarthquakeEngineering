package ui;

import model.RegularToDoTask;
import model.ToDoList;
import model.TooManyThingsToDo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class App {
    //    ArrayList<LogEntry> operationLog = new ArrayList<>();
    ToDoList taskarchive = new ToDoList("archive");
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
        System.out.println("Please enter your task to be added to your TODO list with its importance and due date");
        String tasktitle = scanner.nextLine();
        String importance = scanner.nextLine();
        RegularToDoTask task1 = new RegularToDoTask(tasktitle, RegularToDoTask.Importance.MEDIUM, new Date());
        try {
            taskarchive.addRegularTask(task1);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            System.out.println("Could not add task, due to many being not done");
        } finally {
            System.out.println("Reached finally clause");
        }
        logEntry.addOperand(task1);
        return tasktitle;
    }

    private String two(LogEntry logEntry) {
        System.out.println("Please enter the title of the task you would like to remove");
        String tasktitle = scanner.nextLine();
        for (RegularToDoTask item : taskarchive.getRegTasks()) {
            if (item.getTitle() == tasktitle) {
                try {
                    taskarchive.addRegularTask(item);
                } catch (TooManyThingsToDo tooManyThingsToDo) {
                    System.out.println("Could not add task, due to many being not done");
                } finally {
                    System.out.println("Reached finally clause");
                }
            }
        }
        return tasktitle;
    }

    private List<String> three(LogEntry logEntry) {
        System.out.println("We will print all your active tasks for you!");
        List<String> list = new ArrayList<>();
        for (RegularToDoTask item : taskarchive.getRegTasks()) {
            System.out.println(item.getTitle());
            list.add(item.getTitle());
        }
        return list;
    }
}
