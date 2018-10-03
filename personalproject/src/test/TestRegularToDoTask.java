package test;

import model.RegularToDoTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRegularToDoTask {
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
}
