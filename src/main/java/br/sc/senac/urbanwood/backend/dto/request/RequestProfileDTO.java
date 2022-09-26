package br.sc.senac.urbanwood.backend.dto.request;

import java.time.LocalDate;
import java.util.List;

import br.sc.senac.urbanwood.backend.projection.request.RequestProfileProjection;

public record RequestProfileDTO(Long id,
                                double priceRequest,
                                LocalDate initialDate,
                                List<RequestProfileProjection.FurnitureProjection> furnitureList,
                                String nameClient,
                                String cpf,
                                String email,
                                String phoneNumber,
                                int number,
                                String neighbor,
                                String city,
                                String cep) {
}
