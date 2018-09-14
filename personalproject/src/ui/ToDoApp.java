package ui;

import models.ToDoList;
import models.ToDoTask;

public class ToDoApp {

    public static void main(String[] args) {
        // Create tasks
        ToDoTask t1 = new ToDoTask("First Task", "new", "1");
        ToDoTask t2 = new ToDoTask("Second Task", "pending", "2");
        ToDoTask t3 = new ToDoTask("Third Task", "pending", "1");

        // Print tasks
        printTask(t1);
        printTask(t2);
        printTask(t3);

        // Create ToDoLists
        ToDoList l1 = new ToDoList("CS Tasks");

        // Add items to list
        l1.addTask(t1);
        l1.addTask(t2);

        // Print list
        printList(l1);
    }

    private static void printTask(ToDoTask task) {
        System.out.println("Called printTask");
        System.out.println(task);
    }

    private static void printList(ToDoList list) {
        System.out.println("Called printList");
        System.out.println(list);
    }

}
