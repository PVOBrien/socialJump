package com.pvobrien.socialJump.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long locationId;
    private String place, focus;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="location")
    private List<Person> people;

    public Location() { }

    public Location(String place, String focus) {
        this.place = place;
        this.focus = focus;
    }

    public String getPlace() { return place; }
    public void setPlace(String place) { this.place = place; }

    public String getFocus() { return focus; }
    public void setFocus(String focus) { this.focus = focus; }

    public List<Person> getUsers() { return people; }
    public void setUsers(List<Person> people) { this.people = people; }

    public long getLocationId() { return locationId; }
    public void setLocationId(long locationId) { this.locationId = locationId; }
}
