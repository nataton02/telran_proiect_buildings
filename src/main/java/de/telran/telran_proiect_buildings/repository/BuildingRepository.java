package de.telran.telran_proiect_buildings.repository;

import de.telran.telran_proiect_buildings.entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository<Building, Long> {
}
