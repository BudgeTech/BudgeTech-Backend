package br.sc.senac.budgetech.backend.dto.request;

import br.sc.senac.budgetech.backend.projection.request.RequestWithFurnituresProjection;

import java.util.List;

public record RequestWithFurnituresDTO(List<RequestWithFurnituresProjection.FurnitureProjection> furnitures) {}