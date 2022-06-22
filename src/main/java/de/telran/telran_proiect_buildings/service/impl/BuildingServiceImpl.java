package de.telran.telran_proiect_buildings.service.impl;

import de.telran.telran_proiect_buildings.dto.BuildingRequestDTO;
import de.telran.telran_proiect_buildings.dto.BuildingResponseDTO;
import de.telran.telran_proiect_buildings.entity.Building;
import de.telran.telran_proiect_buildings.repository.BuildingRepository;
import de.telran.telran_proiect_buildings.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Override
    public void createBuilding(BuildingRequestDTO request) {
        Building building = Building.builder()
                .street(request.getStreet())
                .houseNumber(request.getHouseNumber())
                .floorsCount(request.getFloorsCount())
                .build();
        buildingRepository.save(building);
    }

    @Override
    public List<BuildingResponseDTO> getAllBuildings() {
        return buildingRepository.findAll().stream()
                .map(building -> BuildingResponseDTO.builder()
                        .id(building.getId())
                        .houseNumber(building.getHouseNumber())
                        .street(building.getStreet())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public BuildingResponseDTO getBuildingById(Long id) {
        Building building = buildingRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return BuildingResponseDTO.builder()
                .id(building.getId())
                .houseNumber(building.getHouseNumber())
                .street(building.getStreet())
                .build();
    }
}

