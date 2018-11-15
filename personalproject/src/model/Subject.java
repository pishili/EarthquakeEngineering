package model;

import services.Earthquake;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private List<EarthquakeObserver> earthquakeObservers;

    public Subject(){ earthquakeObservers = new ArrayList<>(); }

    public void addObserver(EarthquakeObserver eo) {
        if(!earthquakeObservers.contains(eo)) {
            earthquakeObservers.add(eo);
        }
    }

    public void removeObserver(EarthquakeObserver eo) {
        if(earthquakeObservers.contains(eo)) {
            earthquakeObservers.add(eo);
        }
    }

    public void notifyObservers(Earthquake earthquake) {
        for (EarthquakeObserver eo: earthquakeObservers) {
            eo.update(earthquake);
        }
    }
}
