package br.sc.senac.budgetech.backend.dto.furniture;

import br.sc.senac.budgetech.backend.projection.furniture.FurnitureListProjection;

import java.util.List;

public record FurnitureListDTO(List<FurnitureListProjection> furnitures) {}