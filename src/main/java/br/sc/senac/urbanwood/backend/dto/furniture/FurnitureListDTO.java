package br.sc.senac.urbanwood.backend.dto.furniture;

import java.util.List;

import br.sc.senac.urbanwood.backend.projection.furniture.FurnitureListProjection;

public record FurnitureListDTO(List<FurnitureListProjection> furnitureList) {
}
