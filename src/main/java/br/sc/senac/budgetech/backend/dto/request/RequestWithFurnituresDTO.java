package br.sc.senac.budgetech.backend.dto.request;

import java.util.List;

import static br.sc.senac.budgetech.backend.projection.request.RequestWithFurnituresProjection.FurnitureProjection;

public record RequestWithFurnituresDTO(List<FurnitureProjection> furnitures) {}