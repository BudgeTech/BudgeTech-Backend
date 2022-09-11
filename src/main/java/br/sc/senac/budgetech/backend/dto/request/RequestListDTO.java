package br.sc.senac.budgetech.backend.dto.request;

import br.sc.senac.budgetech.backend.projection.request.RequestListProjection;

import java.util.List;

public record RequestListDTO(List<RequestListProjection> requests) {}