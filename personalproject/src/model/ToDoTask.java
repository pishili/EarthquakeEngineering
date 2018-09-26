package model;

public class ToDoTask {
    private String title;
    private Long id;
    private String status;
    private String importance;

    public ToDoTask(String title, String status, String importance) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.importance = importance;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPriority(String priority) { this.importance = importance; }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public String getTitle() {
        return this.title;
    }

    public String getPriority() {
        return this.importance;
    }

    public String toString(){
        return "Task title: " + title + ", Status: " + status;
    }

}

