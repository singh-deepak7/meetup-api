package com.meetup.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table(name = "meetup", schema = "mysvc")
public class Meetup implements Serializable {
    private long id;
    private String title;
    private String image;
    private String address;
    private String description;
    private LocalDate created_date;
    private LocalDate mofified_date;
    private String created_by;
    private String modified_by;
    private boolean active_sw;

    public Meetup(){

    }
    public Meetup(long id, String title, String image, String address, String description, LocalDate created_date, LocalDate mofified_date, String created_by, String modified_by, boolean active_sw) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.address = address;
        this.description = description;
        this.created_date = created_date;
        this.mofified_date = mofified_date;
        this.created_by = created_by;
        this.modified_by = modified_by;
        this.active_sw = active_sw;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "image_url")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "created_date")
    public LocalDate getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDate created_date) {
        this.created_date = created_date;
    }

    @Column(name = "mofified_date")
    public LocalDate getMofified_date() {
        return mofified_date;
    }

    public void setMofified_date(LocalDate mofified_date) {
        this.mofified_date = mofified_date;
    }

    @Column(name = "created_by")
    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    @Column(name = "modified_by")
    public String getModified_by() {
        return modified_by;
    }

    public void setModified_by(String modified_by) {
        this.modified_by = modified_by;
    }

    @Column(name = "active_sw")
    public boolean isActive_sw() {
        return active_sw;
    }

    public void setActive_sw(boolean active_sw) {
        this.active_sw = active_sw;
    }

    @Override
    public String toString() {
        return "Meetup{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", created_date=" + created_date +
                ", mofified_date=" + mofified_date +
                ", created_by='" + created_by + '\'' +
                ", modified_by='" + modified_by + '\'' +
                ", active_sw=" + active_sw +
                '}';
    }
}
