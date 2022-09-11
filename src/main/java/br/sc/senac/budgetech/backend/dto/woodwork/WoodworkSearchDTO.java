package br.sc.senac.budgetech.backend.dto.woodwork;

import br.sc.senac.budgetech.backend.projection.woodwork.WoodworkSearchProjection;

import java.util.List;

public record WoodworkSearchDTO(List<WoodworkSearchProjection> woodworks) {}
