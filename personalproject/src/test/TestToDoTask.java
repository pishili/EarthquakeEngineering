package test;

import model.ToDoTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestToDoTask {
    private ToDoTask task1;


    @BeforeEach
    public void runBefore() {
        task1 = new ToDoTask("review meeting", ToDoTask.Importance.HIGH, new Date());
    }

    @Test
    public void testConstructor(){
        assertEquals("review meeting", task1.getTitle());
        assertEquals(false, task1.getIsDone());
        assertEquals(ToDoTask.Importance.HIGH, task1.getPriority());
    }

    @Test
    public void testToDoDone(){
        assertEquals(task1.getIsDone(), false);
        task1.setIsDone(true);
        assertEquals(task1.getIsDone(), true);
    }
}
