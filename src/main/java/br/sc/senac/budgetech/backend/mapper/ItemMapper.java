package br.sc.senac.budgetech.backend.mapper;

import br.sc.senac.budgetech.backend.dto.item.ItemDTO;
import br.sc.senac.budgetech.backend.model.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemMapper {

    public ItemDTO toDTO(Item item) {
        return new ItemDTO(item.getId(), item.getQuantity(), item.getTotalPrice(), item.getRequest().getId(), item.getClient().getId(), item.getWoodwork().getId());
    }

    public Item toEntity(ItemDTO dto) {
        return new Item(dto.id(), dto.quantity(), dto.totalPrice());
    }
}
