package model;

import services.Earthquake;

import java.util.Iterator;

public class EarthquakeFakeCentre extends EarthquakeCentre {


    public EarthquakeFakeCentre(String name) {
        super(name);
    }

    @Override
    public Iterator<Earthquake> iterator() {
        return new Iter();

    }

    private class Iter implements Iterator<Earthquake> {
        // we defined the behaviour of iteration.
        private Integer numOfCalls = 0;



        @Override
        public boolean hasNext() {
            return numOfCalls < 3;
        }

        @Override
        public Earthquake next() {
            numOfCalls += 1;
            return getEarthquakes().get(0);
        }

        @Override
        public void remove() {

        }
    }

}
