package test;

import model.MyFakeCollection;
import org.junit.jupiter.api.Test;

public class MyFakeClassTask {

    @Test
    public void testEqualFalse(){
        MyFakeCollection f = new MyFakeCollection();
        for(Integer item: f) {
            System.out.println(item);
        }
    }
}
