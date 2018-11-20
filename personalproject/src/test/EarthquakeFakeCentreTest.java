package test;

import model.EarthquakeFakeCentre;
import org.junit.jupiter.api.Test;
import services.Earthquake;

public class EarthquakeFakeCentreTest {

    @Test
    public void testIterator(){
        EarthquakeFakeCentre efc = new EarthquakeFakeCentre("Geological Survey");
        
        for(Earthquake e: efc) {
            System.out.println(e);
        }
    }


}
