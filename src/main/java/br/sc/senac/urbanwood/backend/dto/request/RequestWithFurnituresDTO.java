package br.sc.senac.urbanwood.backend.dto.request;

import java.sql.Blob;
import java.util.List;

import br.sc.senac.urbanwood.backend.projection.request.RequestWithFurnituresProjection;

public record RequestWithFurnituresDTO(List<RequestWithFurnituresProjection.FurnitureProjection> furnitures) {
}
