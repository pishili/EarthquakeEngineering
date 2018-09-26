package ui;
import model.ToDoList;
import model.ToDoTask;
import ui.LogEntry;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        new App();
        ToDoTask task;
        ToDoList taskarchive = new ToDoList("aList");
//
//        ArrayList<LogEntry> operationLog = new ArrayList<>();
//        Scanner scanner = new Scanner(System.in);
//        ToDoTask task = new ToDoTask();
//        ToDoList taskarchive = new ToDoList();
//
//        // Create tasks
        ToDoTask t1 = new ToDoTask("First Task", "new", new Date());
        ToDoTask t2 = new ToDoTask("Second Task", "pending", new Date());
        ToDoTask t3 = new ToDoTask("Third Task", "pending", new Date());
        ToDoTask t4 = new ToDoTask("Workout Task", "finished" , new Date());

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
