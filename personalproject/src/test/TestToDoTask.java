package test;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TestToDoTask {
    private Task task1;


    @BeforeEach
    public void runBefore() {
        task1 = new Task("review meeting", Prioritizable.Priority.HIGH, new Date());
    }

    @Test
    public void testConstructor(){
        assertEquals("review meeting", task1.getTitle());
        assertEquals(false, task1.getIsDone());
        assertEquals(Prioritizable.Priority.HIGH, task1.getPriority());
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
                toDoList.addTask(
                    new Task("task" + i, Prioritizable.Priority.LOW, new Date())
                );
            }
            System.out.println(toDoList);
            fail("Adding too many tasks did not throw an exception");
        } catch (TooManyRegularThingsToDo e) {
            // Do nothing. It's correct to throw exception here when adding tasks when many are not done yet
        } catch (TooManyUrgentThingsToDo tooManyUrgentThingsToDo) {
            fail("Should not throw this");
        }
    }

    @Test
    public void testAddingNotTooManyRegularTasksDoesNotThrowException(){
        ToDoList toDoList = new ToDoList("MyToDoList");
        try {
            for (int i = 0; i < 5; i++) {
                toDoList.addTask(
                    new Task("task" + i, Prioritizable.Priority.LOW, new Date())
                );
            }
        } catch (TooManyRegularThingsToDo e) {
            fail("We should not throw an exception when number of not done tasks did not reach > 5");
        } catch (TooManyUrgentThingsToDo tooManyUrgentThingsToDo) {
            fail("Should not throw this");
        }
    }

    @Test
    public void testAddingTooManyUrgentTasksThrowsException(){
        ToDoList toDoList = new ToDoList("MyToDoList");
        try {
            for (int i = 0; i < 5; i++) {
                toDoList.addTask(
                    new Task("task" + i, Prioritizable.Priority.HIGH, new Date())
                );
            }
            fail("Adding too many tasks did not Compile the addUrgentTask. This should fail!");
        } catch (TooManyUrgentThingsToDo e) {
            // Do nothing. It's correct to throw exception here when adding tasks when many are not done yet
            System.out.println("Catch the Too Many Tasks have been added");
        } catch (TooManyRegularThingsToDo tooManyRegularThingsToDo) {
            fail("Should not throw this");
        }
    }

    @Test
    public void testAddingNotTooManyUrgentTasksDoesNotThrowException(){
        ToDoList toDoList = new ToDoList("MyToDoList");
        try {
            for (int i = 0; i < 1; i++) {
                toDoList.addTask(
                    new Task("task" + i, Prioritizable.Priority.HIGH, new Date())
                );
            }
        } catch (TooManyUrgentThingsToDo e) {
            fail("We should not throw an exception when number of not done tasks did not reach > 2");
        } catch (TooManyRegularThingsToDo tooManyRegularThingsToDo) {
            fail("Should not throw this");
        }
    }

    @Test
    public void testEqualTrue(){
        Task task1 = new Task("review meeting", Prioritizable.Priority.HIGH, new Date());
        Task task2 = new Task("review meeting", Prioritizable.Priority.HIGH, new Date());
        assertEquals(task1, task2);
    }

    @Test
    public void testEqualFalse(){
        Task task1 = new Task("review meeting", Prioritizable.Priority.HIGH, new Date());
        Task task2 = new Task("review meeting2", Prioritizable.Priority.HIGH, new Date());
        assertNotEquals(task1, task2);

        task1 = new Task("review meeting", Prioritizable.Priority.HIGH, new Date());
        task2 = new Task("review meeting", Prioritizable.Priority.LOW, new Date());
        assertNotEquals(task1, task2);
    }
}
