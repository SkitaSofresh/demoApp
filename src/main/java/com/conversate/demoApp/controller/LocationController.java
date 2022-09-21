package com.conversate.demoApp.controller;

import com.conversate.demoApp.entity.Location;
import com.conversate.demoApp.entity.User;
import com.conversate.demoApp.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping("/locations")
    public List<Location> getAllLocation() {
        return locationService.getAllLocation();
    }

    @GetMapping("/locations/{id}")
    public Optional<Location> getLocation(@PathVariable Long id){
        return locationService.getLocation(id);
    }

    @PostMapping("/location")
    public void addLocation(@RequestBody Location location) {
        locationService.addLocation(location);
    }


    @PutMapping("/locations/{id}")
    public Location updateLocation(@RequestBody Location location, @PathVariable Long id) {

        return locationService.updateLocation(id, location);
    }

    @DeleteMapping("locations/{id}")
    public void deleteLocation(@PathVariable Long id){
        locationService.deleteLocation(id);
    }

}
