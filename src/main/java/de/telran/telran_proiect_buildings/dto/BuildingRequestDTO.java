package de.telran.telran_proiect_buildings.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BuildingRequestDTO {

    private String street;
    private String houseNumber;
    private Integer floorsCount;
}
