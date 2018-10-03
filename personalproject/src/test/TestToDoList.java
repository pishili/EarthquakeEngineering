package test;

import model.RegularToDoTask;
import model.ToDoList;

import java.util.Date;

public class TestToDoList {
    private RegularToDoTask t1;
    private RegularToDoTask t2;
    private RegularToDoTask t3;
    private RegularToDoTask t4;

    private ToDoList myTasks;

    public TestToDoList() {
        t1 = new RegularToDoTask("cs221", RegularToDoTask.Importance.HIGH, new Date());
        t2 = new RegularToDoTask("213", RegularToDoTask.Importance.HIGH, new Date());
        t3 = new RegularToDoTask("121", RegularToDoTask.Importance.HIGH, new Date());
        t4 = new RegularToDoTask("210", RegularToDoTask.Importance.HIGH, new Date());

        myTasks = new ToDoList("MY TASKS");
        myTasks.addTask(t1);
        myTasks.addTask(t2);
        myTasks.addTask(t3);
        myTasks.addTask(t4);
    }
}