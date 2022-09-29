package br.sc.senac.budgetech.service.item;

import br.sc.senac.budgetech.dto.item.ItemDTO;
import br.sc.senac.budgetech.projection.item.ItemProjection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {

    ItemDTO save(ItemDTO itemDTO);

    void update(ItemDTO itemDTO, Long id);

    void delete(Long id);

    ItemProjection findById(Long id);

    List<ItemProjection> findByPrice(Double totalPrice);
}