package com.meetup.model;

import javax.persistence.*;

@Entity
@Table(name = "favorites", schema = "mysvc")
public class Favorites {
    private long id;
    private long meetupId;
    private boolean activeSw;

    public Favorites() {
    }

    public Favorites(long id, long meetupId, boolean activeSw) {
        this.id = id;
        this.meetupId = meetupId;
        this.activeSw = activeSw;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "meetup_id")
    public long getMeetupId() {
        return meetupId;
    }

    public void setMeetupId(long meetupId) {
        this.meetupId = meetupId;
    }

    @Column(name = "active_sw")
    public boolean isActiveSw() {
        return activeSw;
    }

    public void setActiveSw(boolean activeSw) {
        this.activeSw = activeSw;
    }

    @Override
    public String toString() {
        return "Favorites{" +
                "id=" + id +
                ", meetupId=" + meetupId +
                ", activeSw=" + activeSw +
                '}';
    }
}
