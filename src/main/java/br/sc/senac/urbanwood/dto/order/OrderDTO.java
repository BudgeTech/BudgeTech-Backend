package br.sc.senac.urbanwood.dto.order;

import br.sc.senac.urbanwood.enumeration.payment.Payment;
import br.sc.senac.urbanwood.enumeration.status.Status;

import java.time.LocalDate;

public record OrderDTO(Long id,
                       Double priceRequest,
                       Status status,
                       Payment payment,
                       LocalDate initialDate,
                       LocalDate finalDate) {
}