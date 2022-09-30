package br.sc.senac.budgetech.dto.order;

import br.sc.senac.budgetech.enumeration.payment.Payment;
import br.sc.senac.budgetech.enumeration.status.Status;

import java.time.LocalDate;

public record OrderDTO(Long id,
                       Double priceRequest,
                       Status status,
                       Payment payment,
                       LocalDate initialDate,
                       LocalDate finalDate) {
}