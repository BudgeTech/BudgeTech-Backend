package br.sc.senac.urbanwood.dto.order;

import br.sc.senac.urbanwood.enumeration.payment.Payment;
import br.sc.senac.urbanwood.enumeration.status.Status;

import java.time.LocalDate;
import java.util.List;

public record OrderCreateDTO(Long id,
                             Double priceOrder,
                             Status status,
                             Payment payment,
                             LocalDate initialDate,
                             LocalDate finalDate,
                             List<Long> idFurnitures) {
}