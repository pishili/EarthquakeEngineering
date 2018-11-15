package model;

public interface Prioritizable {

    enum Priority {
        HIGH,
        MEDIUM,
        LOW
    }

    Priority getPriority();

    void setPriority(Priority priority);

}
