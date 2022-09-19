package br.sc.senac.budgetech.backend.dto.order;

import br.sc.senac.budgetech.backend.enumeration.Payment;
import br.sc.senac.budgetech.backend.enumeration.Status;

import java.time.LocalDate;
import java.util.List;

public record OrderCreateDTO(Long id,
                             Double priceOrder,
                             Status status,
                             Payment payment,
                             LocalDate initialDate,
                             LocalDate finalDate,
                             List<Long> idFurnitures) {}