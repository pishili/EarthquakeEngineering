package ui;

import model.Prioritizable;
import model.RegularToDoTask;
import model.ToDoList;
import model.TooManyThingsToDo;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {

    //this project illustrates reading from a file, and writing to a file
    //before you run this the first time, the outputfile will be empty
    //you can open outputfile to see that the entries have been written there
    //notice also that the default folder for the files is the main project folder
    //  not the src directory, or whichever package this class is in.

    //this project also illustrates splitting a line up by spaces


    private static ToDoList taskarchive = new ToDoList("aList");

    public static void main(String[] args) throws IOException {


        readFile();

        writeFile();


//        try (PrintWriter writer = new PrintWriter("output.txt", "UTF-8")) {
//          writer.close();
//        }

//        new App();
        RegularToDoTask task;
//
//        ArrayList<LogEntry> operationLog = new ArrayList<>();
//        Scanner scanner = new Scanner(System.in);
//        RegularToDoTask task = new RegularToDoTask();
//        ToDoList taskarchive = new ToDoList();
//
        // Print list
//        printList(l1);
    }


    private static void readFile() throws IOException {

        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get("my_tasks.txt"));
        } catch (IOException e) {
            System.out.println("Could not find my_tasks.txt! Not adding any tasks");
        }

        for (String line : lines) {
            ArrayList<String> partsOfLine = splitOnSpace(line);
            System.out.println("Task Name: " + partsOfLine.get(0) + " ");
            System.out.println("Status: " + partsOfLine.get(1));

            RegularToDoTask task = new RegularToDoTask(partsOfLine.get(0), Prioritizable.Importance.LOW, new Date());
            try {
                taskarchive.addRegularTask(task);
            } catch (TooManyThingsToDo tooManyThingsToDo) {
                System.out.println("Could not add task, due to many being not done");
            } finally {
                System.out.println("Reached finally clause");
            }
        }
    }

    private static void writeFile() throws IOException {
        // Create tasks
        RegularToDoTask t1 = new RegularToDoTask("First_Task", RegularToDoTask.Importance.HIGH, new Date());
        RegularToDoTask t2 = new RegularToDoTask("Second_Task", RegularToDoTask.Importance.LOW, new Date());
        RegularToDoTask t3 = new RegularToDoTask("Third_Task", RegularToDoTask.Importance.MEDIUM, new Date());
        RegularToDoTask t4 = new RegularToDoTask("Workout_Task", RegularToDoTask.Importance.HIGH , new Date());

        //Create ToDoLists
        ToDoList l1 = new ToDoList("CS Tasks");

        //Add items to list
        try {
            taskarchive.addRegularTask(t1);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            System.out.println("Could not add task, due to many being not done");
        } finally {
            System.out.println("Reached finally clause");
        }

        try {
            taskarchive.addRegularTask(t2);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            System.out.println("Could not add task, due to many being not done");
        } finally {
            System.out.println("Reached finally clause");
        }

        try {
            taskarchive.addRegularTask(t3);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            System.out.println("Could not add task, due to many being not done");
        } finally {
            System.out.println("Reached finally clause");
        }

        try (PrintWriter writer = new PrintWriter("output.txt", "UTF-8")) {
            for(RegularToDoTask task: l1.getRegTasks().values()) {
                writer.write(task.getTitle() + " " + task.getImportance() + "\n");
            }
        }
    }

    public static ArrayList<String> splitOnSpace(String line){
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
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
