package br.sc.senac.budgetech.backend.dto.request;

import br.sc.senac.budgetech.backend.enumeration.Payment;
import br.sc.senac.budgetech.backend.enumeration.Status;

import java.time.LocalDate;

public record RequestDTO(Long id,
                         Double priceRequest,
                         Status status,
                         Payment payment,
                         LocalDate initialDate,
                         LocalDate finalDate) {}