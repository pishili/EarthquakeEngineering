package test;

import model.ToDoTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestToDoTask {
    private ToDoTask task1;


    @BeforeEach
    public void runBefore() {
        task1 = new ToDoTask("review meeting", "not finished", "very important");
    }

    @Test
    public void testConstructor(){
        assertEquals("review meeting", task1.getTitle());
        assertEquals("not finished", task1.getStatus());
        assertEquals("very important", task1.getPriority());
    }

    @Test
    public void testToDoDone(){
        task1.isDone(20012-10-4 10:15:25);


    }
}
