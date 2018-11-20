package model;

import services.Earthquake;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EarthquakeCentre extends Subject implements Iterable<Earthquake> {
    private List<Earthquake> earthquakes = new ArrayList<>();
    private String name;

    public EarthquakeCentre(String name) {
        super();
//        this.earthquakes = new GetEarthquakeFromCSV();

        name = name;
        this.earthquakes.add(
                new Earthquake(2.4, 3.7, 4.3, 3.3, "2 pm")
        );
        this.earthquakes.add(
                new Earthquake(1.1, 2.7, 1.3, 4.3, "6 pm")
        );

    }

    public String getName() {
        return name;
    }

    // the behaviour I want to notify observers with
    public void getBigEarthquake() {
        for(Earthquake e: earthquakes) {
            if(e.getMagnitude() > 4) {
                notifyObservers(e);
            }
        }
    }

    public List<Earthquake> getEarthquakes() {
        return earthquakes;
    }

    @Override
    public Iterator iterator() {
        // USE the iterator whatever list has
        return earthquakes.iterator();
    }
}

