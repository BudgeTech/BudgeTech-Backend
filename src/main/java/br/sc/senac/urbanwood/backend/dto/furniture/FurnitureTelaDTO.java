package br.sc.senac.urbanwood.backend.dto.furniture;

import java.sql.Blob;

public record FurnitureTelaDTO(String nameFurniture, Blob image, double priceFurniture) {
}
