package com.DRServer.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

/**
 * Created by Hampus on 2017-01-15.
 */

@Entity
public class Reminder {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JsonBackReference
    private User user;
    private int startTime;
    private int endTime;
    private String days;

    private String title;
    private String Description;

    private boolean done;

    private Reminder(){}

    public Reminder(int startTime, int endTime, String title, String days) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.title = title;
        this.days = days;

    }

    public Reminder(User user, int startTime, int endTime, String title, String days) {
        this.user = user;
        this.startTime = startTime;
        this.endTime = endTime;
        this.title = title;
        this.days = days;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
