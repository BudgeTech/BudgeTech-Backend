package br.sc.senac.budgetech.backend.dto.order;

import br.sc.senac.budgetech.backend.enumeration.Payment;
import br.sc.senac.budgetech.backend.enumeration.Status;

import java.time.LocalDate;

public record OrderDTO(Long id,
                       Double priceRequest,
                       Status status,
                       Payment payment,
                       LocalDate initialDate,
                       LocalDate finalDate) {}