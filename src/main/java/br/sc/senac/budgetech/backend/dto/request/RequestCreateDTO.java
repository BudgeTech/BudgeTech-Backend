package br.sc.senac.budgetech.backend.dto.request;

import br.sc.senac.budgetech.backend.enumeration.Payment;
import br.sc.senac.budgetech.backend.enumeration.Status;

import java.time.LocalDate;
import java.util.List;

public record RequestCreateDTO(Long id, double price, Status status, Payment payment, LocalDate initialDate,
                               LocalDate finalDate, List<Long> idsFurnitures) {
}
