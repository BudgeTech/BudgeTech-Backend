package br.sc.senac.budgetech.backend.dto.request;

import br.sc.senac.budgetech.backend.projection.request.RequestWithFurnituresProjection;

import java.util.List;

import static br.sc.senac.budgetech.backend.projection.request.RequestWithFurnituresProjection.*;

public record RequestWithFurnituresDTO(List<FurnitureProjection> furnitures) {}