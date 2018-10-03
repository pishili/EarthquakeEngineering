package model;

import java.util.ArrayList;
import java.util.List;

public class User {

    public static List<String> userEmails;

    private final String name;
    private String email;
    private ToDoList list;
    private ArrayList<RegularToDoTask> tasks;


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
        userEmails = userEmailz;
    }



}
