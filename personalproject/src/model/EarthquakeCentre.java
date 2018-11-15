package model;

import services.Earthquake;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeCentre extends Subject {
    private List<Earthquake> earthquakes;
    private String name;

    public EarthquakeCentre(String name) {
        super();
        name = name;
        earthquakes = new ArrayList<>();
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
}

