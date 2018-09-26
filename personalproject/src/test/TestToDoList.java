package test;

import model.ToDoTask;
import model.ToDoList;

public class TestToDoList {
    private ToDoTask t1;
    private ToDoTask t2;
    private ToDoTask t3;
    private ToDoTask t4;

    private ToDoList myTasks;

    public TestToDoList() {
        t1 = new ToDoTask("cs221", "not started", "super improtant");
        t2 = new ToDoTask("213", "not started", "important");
        t3 = new ToDoTask("121", "finished", "super important");
        t4 = new ToDoTask("210", "In Progress", "Super important");

        myTasks = new ToDoList("MY TASKS");
        myTasks.addTask(t1);
        myTasks.addTask(t2);
        myTasks.addTask(t3);
        myTasks.addTask(t4);
    }
}