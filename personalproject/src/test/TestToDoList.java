package test;

import model.ToDoTask;
import model.ToDoList;

import java.util.Date;

public class TestToDoList {
    private ToDoTask t1;
    private ToDoTask t2;
    private ToDoTask t3;
    private ToDoTask t4;

    private ToDoList myTasks;

    public TestToDoList() {
        t1 = new ToDoTask("cs221", "important", new Date());
        t2 = new ToDoTask("213", "not important", new Date());
        t3 = new ToDoTask("121", "super important", new Date());
        t4 = new ToDoTask("210", "Super important", new Date());

        myTasks = new ToDoList("MY TASKS");
        myTasks.addTask(t1);
        myTasks.addTask(t2);
        myTasks.addTask(t3);
        myTasks.addTask(t4);
    }
}