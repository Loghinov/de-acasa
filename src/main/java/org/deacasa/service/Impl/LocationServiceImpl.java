package org.deacasa.service.Impl;

import org.deacasa.entity.Location;
import org.deacasa.repository.LocationRepo;
import org.deacasa.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepo locationRepo;
    @Autowired
    public LocationServiceImpl(LocationRepo locationRepo){this.locationRepo=locationRepo;}

    @Override
    public List<Location> getAllLocations() {
        return locationRepo.findAll();
    }

    @Override
    public Location getLocationById(Long id) {
        return locationRepo.findById(id)
                .orElseThrow(() ->new RuntimeException("Location not found"));
    }

    @Override
    public Location saveLocation(Location location) {
        return locationRepo.save(location);
    }

    @Override
    public Location updateLocation(Long id, Location location) {
        Location location1=getLocationById(id);
        location1.setLocationCity(location.getLocationCity());
        location1.setLocationRegion(location.getLocationRegion());
        location1.setLocationAddress(location.getLocationAddress());
        return locationRepo.save(location1);
    }

    @Override
    public void deleteLocation(Long id) {
        locationRepo.deleteById(id);

    }
}
