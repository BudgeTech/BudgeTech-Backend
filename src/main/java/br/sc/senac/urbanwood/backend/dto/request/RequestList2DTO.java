package br.sc.senac.urbanwood.backend.dto.request;

import java.util.List;

import br.sc.senac.urbanwood.backend.projection.request.RequestListProjection;

public record RequestList2DTO(List<RequestListProjection> requests) {
}
