package ui;
import model.RegularToDoTask;
import model.ToDoList;

import java.util.Date;

public class Main {


    public static void main(String[] args) {
        new App();
        RegularToDoTask task;
        ToDoList taskarchive = new ToDoList("aList");
//
//        ArrayList<LogEntry> operationLog = new ArrayList<>();
//        Scanner scanner = new Scanner(System.in);
//        RegularToDoTask task = new RegularToDoTask();
//        ToDoList taskarchive = new ToDoList();
//
//        // Create tasks
        RegularToDoTask t1 = new RegularToDoTask("First Task", RegularToDoTask.Importance.HIGH, new Date());
        RegularToDoTask t2 = new RegularToDoTask("Second Task", RegularToDoTask.Importance.LOW, new Date());
        RegularToDoTask t3 = new RegularToDoTask("Third Task", RegularToDoTask.Importance.MEDIUM, new Date());
        RegularToDoTask t4 = new RegularToDoTask("Workout Task", RegularToDoTask.Importance.HIGH , new Date());

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

    private static void printTask(RegularToDoTask task) {
        System.out.println("Called printTask");
        System.out.println(task);
    }

    // add a toDo list item
    private static void printList(ToDoList list) {
        System.out.println("Called printList");
        System.out.println(list);
    }

}
