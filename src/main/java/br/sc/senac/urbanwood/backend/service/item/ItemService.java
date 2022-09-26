package br.sc.senac.urbanwood.backend.service.item;

import br.sc.senac.urbanwood.backend.dto.item.ItemDTO;
import br.sc.senac.urbanwood.backend.projection.item.ItemProjection;

import org.springframework.stereotype.Service;

@Service
public interface ItemService {

    ItemDTO save(ItemDTO itemDTO);

    void update(ItemDTO itemDTO, Long id);

    void delete(Long id);

    ItemProjection findById(Long id);

    ItemProjection findByPrice(double totalPrice);
}