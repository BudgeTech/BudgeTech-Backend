package br.sc.senac.urbanwood.backend.dto.request;

import java.time.LocalDate;
import java.util.List;

import br.sc.senac.urbanwood.backend.enumeration.Payment;
import br.sc.senac.urbanwood.backend.enumeration.Status;

public record RequestCreateDTO(Long id, double priceRequest, Status status, Payment payment, LocalDate initialDate,
                               LocalDate finalDate, List<Long> idsFurnitures) {
}
