package br.sc.senac.budgetech.backend.service.item;

import br.sc.senac.budgetech.backend.dto.item.ItemDTO;
import br.sc.senac.budgetech.backend.exception.client.ClientNotFoundException;
import br.sc.senac.budgetech.backend.exception.item.ItemInvalidException;
import br.sc.senac.budgetech.backend.exception.item.ItemNotFoundException;
import br.sc.senac.budgetech.backend.exception.order.OrderNotFoundException;
import br.sc.senac.budgetech.backend.exception.woodwork.WoodworkNotFoundException;
import br.sc.senac.budgetech.backend.mapper.item.ItemMapper;
import br.sc.senac.budgetech.backend.model.client.Client;
import br.sc.senac.budgetech.backend.model.item.Item;
import br.sc.senac.budgetech.backend.model.order.Order;
import br.sc.senac.budgetech.backend.model.woodwork.Woodwork;
import br.sc.senac.budgetech.backend.projection.item.ItemProjection;
import br.sc.senac.budgetech.backend.repository.client.ClientRepository;
import br.sc.senac.budgetech.backend.repository.item.ItemRepository;
import br.sc.senac.budgetech.backend.repository.order.OrderRepository;
import br.sc.senac.budgetech.backend.repository.woodwork.WoodworkRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;
    private ItemMapper itemMapper;
    private OrderRepository orderRepository;
    private ClientRepository clientRepository;
    private WoodworkRepository woodworkRepository;

    public ItemDTO save(ItemDTO itemDTO) {

        Order order = orderRepository.findById(itemDTO.idOrder())
                .orElseThrow(() -> new OrderNotFoundException("Order " + itemDTO.idOrder() + " was not found"));

        Client client = clientRepository.findById(itemDTO.idClient())
                .orElseThrow(() -> new ClientNotFoundException("Client " + itemDTO.idClient() + " was not found"));

        Woodwork woodwork = woodworkRepository.findById(itemDTO.idWoodwork())
                .orElseThrow(() -> new WoodworkNotFoundException("Woodwork " + itemDTO.idWoodwork() + " was not found"));

        if (itemDTO.totalPrice() < 0)
            throw new ItemInvalidException("Total Price " + itemDTO.totalPrice() + " is invalid");

        if (itemDTO.quantity() < 0)
            throw new ItemInvalidException("Quantity " + itemDTO.quantity() + " is invalid");

        Item item = itemMapper.toEntity(itemDTO);
        item.setOrder(order);
        item.setClient(client);
        item.setWoodwork(woodwork);
        Item itemSaved = itemRepository.save(item);
        return itemMapper.toDTO(itemSaved);
    }

    public void update(ItemDTO itemDTO, Long id) {

        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item " + id + " was not found"));

        if (itemDTO.totalPrice() < 0)
            throw new ItemInvalidException("Total Price " + itemDTO.totalPrice() + " is invalid");

        if (itemDTO.quantity() < 0)
            throw new ItemInvalidException("Quantity " + itemDTO.quantity() + " is invalid");

        item.setQuantity(itemDTO.quantity());
        item.setTotalPrice(itemDTO.totalPrice());
        itemRepository.save(item);
    }

    public void delete(Long id) {
        if (!itemRepository.existsById(id))
            throw new ItemNotFoundException("Item " + id + " was not found");
        itemRepository.deleteById(id);
    }

    public ItemProjection findById(Long id) {
        return itemRepository.findItemById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item " + id + " was not found"));
    }

    public List<ItemProjection> findByPrice(Double totalPrice) {
        List<ItemProjection> item = itemRepository.findItemByTotalPrice(totalPrice);
        if(item.isEmpty())
            throw new ItemNotFoundException("Item " + totalPrice + " was not found");
        return item;
    }
}