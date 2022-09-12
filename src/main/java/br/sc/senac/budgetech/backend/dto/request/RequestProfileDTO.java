package br.sc.senac.budgetech.backend.dto.request;

import br.sc.senac.budgetech.backend.projection.request.RequestProfileProjection;

import java.time.LocalDate;
import java.util.List;

public record RequestProfileDTO(Long id,
                                Double priceRequest,
                                LocalDate initialDate,
                                List<RequestProfileProjection.FurnitureProjection> furnitures,
                                String nameClient,
                                String cpf,
                                String email,
                                String phoneNumber,
                                int number,
                                String neighborhood,
                                String city,
                                String cep) {}