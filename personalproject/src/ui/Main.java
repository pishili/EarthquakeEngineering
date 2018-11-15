package ui;

import model.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


// COMMENTS: For UI, Create A GUI that shows the earthquake Magnitudes on Circles/
// User will be able to specify Start Time and End Time and based on this
// Time I get a Map of Earthquakes with various Circle Diameters
// So implement a GUI
// Render the Earthquale Circles and
// Then start thinking about How to add ToDoList to this.


public class Main {

    //this project illustrates reading from a file, and writing to a file
    //before you run this the first time, the outputfile will be empty
    //you can open outputfile to see that the entries have been written there
    //notice also that the default folder for the files is the main project folder
    //  not the src directory, or whichever package this class is in.

    //this project also illustrates splitting a line up by spaces

    private static ToDoList taskarchive = new ToDoList("aList");

    EarthquakeCentre tehranEC= new EarthquakeCentre("University of Tehran");
    User userLadan = new User("Ladan", "ladanks@gmail.com");
//    tehranearthquakeCentre.addObserver(userLadan);
//    userLadan = (EarthquakeObserver) userLadan;

//    earthquake.addObserver(userLadan);


    public static void main(String[] args) throws IOException {

        readFile();

        writeFile();
//        try (PrintWriter writer = new PrintWriter("output.txt", "UTF-8")) {
//          writer.close();
//        }

//        new App();
        Task task;
//
//        ArrayList<LogEntry> operationLog = new ArrayList<>();
//        Scanner scanner = new Scanner(System.in);
//        Task task = new Task();
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

            Task task = new Task(partsOfLine.get(0), Prioritizable.Priority.LOW, new Date());
            try {
                taskarchive.addTask(task);
            } catch (TooManyThingsToDo tooManyThingsToDo) {
                System.out.println("Could not add task, due to many being not done");
            } finally {
                System.out.println("Reached finally clause");
            }
        }
    }

    private static void writeFile() throws IOException {
        // Create tasks
        Task t1 = new Task("First_Task", Prioritizable.Priority.HIGH, new Date());
        Task t2 = new Task("Second_Task", Prioritizable.Priority.LOW, new Date());
        Task t3 = new Task("Third_Task", Prioritizable.Priority.MEDIUM, new Date());
        Task t4 = new Task("Workout_Task", Prioritizable.Priority.HIGH , new Date());

        //Create ToDoLists
        ToDoList l1 = new ToDoList("CS Tasks");

        //Add items to list
        try {
            taskarchive.addTask(t1);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            System.out.println("Could not add task, due to many being not done");
        } finally {
            System.out.println("Reached finally clause");
        }

        try {
            taskarchive.addTask(t2);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            System.out.println("Could not add task, due to many being not done");
        } finally {
            System.out.println("Reached finally clause");
        }

        try {
            taskarchive.addTask(t3);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            System.out.println("Could not add task, due to many being not done");
        } finally {
            System.out.println("Reached finally clause");
        }

        try (PrintWriter writer = new PrintWriter("output.txt", "UTF-8")) {
            for(Task task: l1.getRegTasks().values()) {
                writer.write(task.getTitle() + " " + task.getPriority() + "\n");
            }
        }
    }

    public static ArrayList<String> splitOnSpace(String line){
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }

    private static void printTask(Task task) {
        System.out.println("Called printTask");
        System.out.println(task);
    }

    // add a toDo list item
    private static void printList(ToDoList list) {
        System.out.println("Called printList");
        System.out.println(list);
    }

}
