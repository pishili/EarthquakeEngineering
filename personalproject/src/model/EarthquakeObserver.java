package model;
import services.Earthquake;

public interface EarthquakeObserver {

    public void update(Earthquake earthquake);
}
