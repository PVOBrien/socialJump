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
    private List<User> users;

    public Location() { }
    public Location(String place, String focus) {
        this.place = place;
        this.focus = focus;
    }

    public String getPlace() { return place; }
    public void setPlace(String place) { this.place = place; }

    public String getFocus() { return focus; }
    public void setFocus(String focus) { this.focus = focus; }

    public List<User> getUsers() { return users; }
    public void setUsers(List<User> users) { this.users = users; }
}
