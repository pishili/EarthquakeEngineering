package model;

public interface Prioritizable {

    enum Importance {
        HIGH,
        MEDIUM,
        LOW
    }

    Importance getPriority();

    void setPriority(Importance priority);

}
