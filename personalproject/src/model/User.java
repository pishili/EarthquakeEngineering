package model;

import services.Earthquake;

import java.util.List;

public class User implements EarthquakeObserver {

    public static List<String> userEmails;

    private final String name;
    private String email;
    private ToDoList list;
//    private ArrayList<RegularToDoTask> tasks;
    private ToDoList tasks;


    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        return "Name: " + getName() + ", Mail: " + getEmail();
    }

    public static List<String> getUserEmails() {
        return userEmails;
    }

    public static void setUserEmails(List<String> userEmailz) {
        userEmails = userEmails;
    }

    @Override
    public void update(Earthquake earthquake) {
        System.out.println("Urgent Alert: Earthquake within depth of  " + earthquake.getDepth() + "meters " + "happened within magnitude of " + earthquake.getMagnitude() + "Richters" );

//        User urgentEarthAlertSubscriber = (User)  o;
//        System.out.println(o.getName());
//
//        String message = (String) arg;
//        System.out.println(message);

    }

}
