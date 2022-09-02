package br.sc.senac.budgetech.backend.service.item;

import br.sc.senac.budgetech.backend.dto.ItemDTO;
import br.sc.senac.budgetech.backend.mapper.ItemMapper;
import br.sc.senac.budgetech.backend.model.Item;
import br.sc.senac.budgetech.backend.projection.ItemWithFurnitureProjection;
import br.sc.senac.budgetech.backend.repository.ItemRepository;
import br.sc.senac.budgetech.backend.repository.RequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;
    private ItemMapper itemMapper;
    private RequestRepository requestRepository;

    @Override
    public ItemDTO save(ItemDTO itemDTO) {
        return null;
    }

    @Override
    public void update(ItemDTO itemDTO, Long id) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Item findById(Long id) {
        return null;
    }

    @Override
    public ItemWithFurnitureProjection findByPrice(double totalPrice) {
        return null;
    }
}