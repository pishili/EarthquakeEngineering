package services;

public class Earthquake {
    protected double latitude;
    protected double longitude;
    protected double depth;
    protected double magnitude;
    protected String time;

    public Earthquake (double latitude, double longitude, double depth, double magnitude, String time) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.depth = depth;
        this.magnitude = magnitude;
        this.time = time;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public Double getlongitude() {
        return this.longitude;
    }

    public Double getDepth() {
        return this.depth;
    }

    public Double getMagnitude() {
        return this.magnitude;
    }

    public String getTime() {
        return this.time;
    }

    @Override
    public String toString() {
        return "Earthquake [Latitude= " + this.getLatitude() +
            " , Longitude=" + this.getlongitude() +
            " , Depth=" + this.getDepth() +
            " , Magnitude=" + this.getMagnitude() +
            " , Time=" + this.getTime() +
            "]";
    }
}
