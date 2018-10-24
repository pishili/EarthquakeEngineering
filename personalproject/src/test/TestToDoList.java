package test;

import model.RegularToDoTask;
import model.UrgentTask;

import java.util.Date;

public abstract class TestToDoList {
    private RegularToDoTask t1;
    private RegularToDoTask t2;
    private RegularToDoTask t3;
    private RegularToDoTask t4;

    private UrgentTask t5;
    private UrgentTask t6;
    private UrgentTask t7;
    private UrgentTask t8;


//    ToDoList myTasks = new ToDoList<RegularToDoTask>;

    public TestToDoList() {
        t1 = new RegularToDoTask("cs221", RegularToDoTask.Importance.HIGH, new Date());
        t2 = new RegularToDoTask("213", RegularToDoTask.Importance.HIGH, new Date());
        t3 = new RegularToDoTask("121", RegularToDoTask.Importance.HIGH, new Date());
        t4 = new RegularToDoTask("210", RegularToDoTask.Importance.HIGH, new Date());

        t5 = new UrgentTask("Committee metting", new Date());
        t6 = new UrgentTask("Entrepenurship", new Date());

//        myTasks = new ToDoList("MY TASKS");
//        myTasks.addRegularTask(t1);
//        myTasks.addRegularTask(t2);

    }
}