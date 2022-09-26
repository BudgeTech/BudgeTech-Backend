package br.sc.senac.urbanwood.backend.dto.request;

import java.time.LocalDate;

import br.sc.senac.urbanwood.backend.enumeration.Payment;
import br.sc.senac.urbanwood.backend.enumeration.Status;

public record RequestDTO(Long id, double priceRequest, Status status, Payment payment, LocalDate initialDate,
                         LocalDate finalDate) {
}