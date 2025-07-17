package org.deacasa.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.deacasa.entity.Location;
import org.deacasa.service.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
@RequiredArgsConstructor
@Tag(name="Location", description = "Управление локацией")
public class LocationController {

    private final LocationService locationService;

    // Получение всех локаций
    @GetMapping("/get-all")
    public List<Location> getAllLocations() {
        return locationService.getAllLocations();
    }

    // Получение локации по ID
    @GetMapping("/get/{id}")
    public Location getLocationById(@PathVariable Long id) {
        return locationService.getLocationById(id);
    }

    // Создание новой локации
    @PostMapping("/save")
    public Location saveLocation(@RequestBody Location location) {
        return locationService.saveLocation(location);
    }

    // Обновление локации
    @PutMapping("/update/{id}")
    public Location updateLocation(@PathVariable Long id, @RequestBody Location location) {
        return locationService.updateLocation(id, location);
    }

    // Удаление локации
    @DeleteMapping("/delete/{id}")
    public void deleteLocation(@PathVariable Long id) {
        locationService.deleteLocation(id);
    }
}