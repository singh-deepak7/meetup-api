package com.meetup.model;

import java.io.Serializable;
import java.time.LocalDate;

public class FavMeetup implements Serializable {
    private long id;
    private String title;
    private String image;
    private String address;
    private String description;
    private long meetupId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getMeetupId() {
        return meetupId;
    }

    public void setMeetupId(long meetupId) {
        this.meetupId = meetupId;
    }
}
