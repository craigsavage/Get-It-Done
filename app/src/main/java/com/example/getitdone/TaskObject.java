package com.example.getitdone;

import android.location.Location;

import java.io.Serializable;

public class TaskObject implements Serializable {
    String name;
    String category;
    String time;
    String date;
    int importance;
    int id;

    public TaskObject(String name, String category, String time, String date, int importance, int id) {
        this.name = name;
        this.category = category;
        this.time = time;
        this.date = date;
        this.importance = importance;
        this.id = id;
    }

    public TaskObject(String name) {
        this.name = name;
    }

    /**
     * Getters and setters for the object
     */


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String host) {
        this.category = host;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }
}
