package com.pvobrien.socialJump.domain;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String userName, favoriteColor;
    private int number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location")
    private Location location;

    public User() { } // gotta have an empty public constructor

    public User(String userName, int number, Location location) {
        this.userName = userName;
        this.number = number;
        this.favoriteColor = "color";
        this.location = location;
    }


    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getFavoriteColor() { return favoriteColor; }
    public void setFavoriteColor(String favoriteColor) { this.favoriteColor = favoriteColor; }

    public int getNumber() { return number; }
    public void setNumber(int aNumber) { this.number = aNumber; }

    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }
}
