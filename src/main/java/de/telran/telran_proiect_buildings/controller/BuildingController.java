package de.telran.telran_proiect_buildings.controller;

import de.telran.telran_proiect_buildings.dto.BuildingRequestDTO;
import de.telran.telran_proiect_buildings.dto.BuildingResponseDTO;
import de.telran.telran_proiect_buildings.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @GetMapping("/buildings")
    public List<BuildingResponseDTO> getAllBuildings() {
        return buildingService.getAllBuildings();
    }

    @GetMapping("/buildings/{id}")
    public BuildingResponseDTO getBuildingById(@PathVariable("id") Long id) {
        return buildingService.getBuildingById(id);
    }

    @PostMapping("/buildings")
    public void createBuilding(@RequestBody BuildingRequestDTO request) {
        buildingService.createBuilding(request);
    }
}
