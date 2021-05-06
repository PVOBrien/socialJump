package com.pvobrien.socialJump.controller;

import com.pvobrien.socialJump.domain.Location;
import com.pvobrien.socialJump.domain.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @RequestMapping("/location")
    public Iterable<Location> getLocation() { return locationRepository.findAll(); }

}
