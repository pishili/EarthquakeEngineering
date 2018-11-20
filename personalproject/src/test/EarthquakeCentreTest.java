package test;

import model.EarthquakeCentre;
import org.junit.jupiter.api.Test;
import services.Earthquake;

public class EarthquakeCentreTest {

    @Test
    public void testIterator(){
        EarthquakeCentre ec = new EarthquakeCentre("Geological Survey");

        for(Earthquake e: ec) {
            System.out.println(e);
        }
    }
}
