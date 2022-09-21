package com.conversate.demoApp.service;

import com.conversate.demoApp.entity.Location;
import com.conversate.demoApp.entity.User;
import com.conversate.demoApp.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;
    public List<Location> getAllLocation() {
        return locationRepository.findAll();
    }

    public Optional<Location> getLocation(Long id) {
        return locationRepository.findById(id);
    }


    public void addLocation(Location location) {
        locationRepository.save(location);
    }

    public Location updateLocation(Long id, Location location) {
        //find location by id
        Location existingLocation = locationRepository.findById(id).orElseThrow(() -> new RuntimeException());
        existingLocation.setName(location.getName());

        //save updated location
        locationRepository.save(existingLocation);
        return existingLocation;

    }

    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}
