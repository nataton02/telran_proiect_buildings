package de.telran.telran_proiect_buildings.service;

import de.telran.telran_proiect_buildings.dto.BuildingRequestDTO;
import de.telran.telran_proiect_buildings.dto.BuildingResponseDTO;

import java.util.List;

public interface BuildingService{

    void createBuilding(BuildingRequestDTO request);

    List<BuildingResponseDTO> getAllBuildings();

    BuildingResponseDTO getBuildingById(Long id);
}
