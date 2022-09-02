package br.sc.senac.budgetech.backend.service.item;

import br.sc.senac.budgetech.backend.dto.ItemDTO;
import br.sc.senac.budgetech.backend.model.Item;
import br.sc.senac.budgetech.backend.projection.ItemWithFurnitureProjection;
import org.springframework.stereotype.Service;

@Service
public interface ItemService {

    ItemDTO save(ItemDTO itemDTO);

    void update(ItemDTO itemDTO, Long id);

    void delete(Long id);

    Item findById(Long id);

    ItemWithFurnitureProjection findByPrice(double totalPrice);
}