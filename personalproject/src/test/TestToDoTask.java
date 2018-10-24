package test;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestToDoTask {
    private RegularToDoTask task1;


    @BeforeEach
    public void runBefore() {
        task1 = new RegularToDoTask("review meeting", RegularToDoTask.Importance.HIGH, new Date());
    }

    @Test
    public void testConstructor(){
        assertEquals("review meeting", task1.getTitle());
        assertEquals(false, task1.getIsDone());
        assertEquals(RegularToDoTask.Importance.HIGH, task1.getPriority());
    }

    @Test
    public void testToDoDone(){
        assertEquals(task1.getIsDone(), false);
        task1.setIsDone(true);
        assertEquals(task1.getIsDone(), true);
    }

    @Test
    public void testAddingTooManyRegularTasksThrowsException(){
        ToDoList toDoList = new ToDoList("MyToDoList");
        try {
            for (int i = 0; i < 10; i++) {
                toDoList.addRegularTask(
                    new RegularToDoTask("task" + i, RegularToDoTask.Importance.HIGH, new Date())
                );
            }
            fail("Adding too many tasks did not throw an exception");
        } catch (TooManyRegularThingsToDo e) {
            // Do nothing. It's correct to throw exception here when adding tasks when many are not done yet
        }
    }

    @Test
    public void testAddingNotTooManyRegularTasksDoesNotThrowException(){
        ToDoList toDoList = new ToDoList("MyToDoList");
        try {
            for (int i = 0; i < 5; i++) {
                toDoList.addRegularTask(
                    new RegularToDoTask("task" + i, RegularToDoTask.Importance.HIGH, new Date())
                );
            }
        } catch (TooManyRegularThingsToDo e) {
            fail("We should not throw an exception when number of not done tasks did not reach > 5");
        }
    }

    @Test
    public void testAddingTooManyUrgentTasksThrowsException(){
        ToDoList toDoList = new ToDoList("MyToDoList");
        try {
            for (int i = 0; i < 5; i++) {
                toDoList.addUrgentTask(
                    new UrgentTask("task" + i, new Date())
                );
            }
            fail("Adding too many tasks did not Compile the addUrgentTask. This should fail!");
        } catch (TooManyUrgentThingsToDo e) {
            // Do nothing. It's correct to throw exception here when adding tasks when many are not done yet
            System.out.println("Catch the Too Many Tasks have been added");
        }
    }

    @Test
    public void testAddingNotTooManyUrgentTasksDoesNotThrowException(){
        ToDoList toDoList = new ToDoList("MyToDoList");
        try {
            for (int i = 0; i < 1; i++) {
                toDoList.addUrgentTask(
                    new UrgentTask("task" + i, new Date())
                );
            }
        } catch (TooManyUrgentThingsToDo e) {
            fail("We should not throw an exception when number of not done tasks did not reach > 2");
        }
    }
}
