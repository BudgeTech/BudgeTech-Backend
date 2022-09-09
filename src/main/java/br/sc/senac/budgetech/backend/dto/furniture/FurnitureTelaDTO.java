package br.sc.senac.budgetech.backend.dto.furniture;

import java.sql.Blob;

public record FurnitureTelaDTO(String name, Blob image, double price) {
}
