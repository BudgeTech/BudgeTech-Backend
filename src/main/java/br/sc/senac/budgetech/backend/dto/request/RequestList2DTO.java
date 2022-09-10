package br.sc.senac.budgetech.backend.dto.request;

import br.sc.senac.budgetech.backend.projection.request.RequestListProjection;

import java.util.List;

public record RequestList2DTO(List<RequestListProjection> requests) {
}
