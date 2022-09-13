package br.sc.senac.budgetech.backend.dto.furniture;

import java.sql.Blob;

public record FurnitureScreenDTO(String nameFurniture,
                                 Blob image,
                                 Double priceFurniture) {}