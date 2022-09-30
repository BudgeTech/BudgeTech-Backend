package br.sc.senac.urbanwood.service.item;

import br.sc.senac.urbanwood.dto.item.ItemDTO;
import br.sc.senac.urbanwood.exception.client.ClientNotFoundException;
import br.sc.senac.urbanwood.exception.item.ItemInvalidException;
import br.sc.senac.urbanwood.exception.item.ItemNotFoundException;
import br.sc.senac.urbanwood.exception.order.OrderNotFoundException;
import br.sc.senac.urbanwood.exception.woodwork.WoodworkNotFoundException;
import br.sc.senac.urbanwood.mapper.item.ItemMapper;
import br.sc.senac.urbanwood.model.client.Client;
import br.sc.senac.urbanwood.model.item.Item;
import br.sc.senac.urbanwood.model.order.Order;
import br.sc.senac.urbanwood.model.woodwork.Woodwork;
import br.sc.senac.urbanwood.projection.item.ItemProjection;
import br.sc.senac.urbanwood.repository.client.ClientRepository;
import br.sc.senac.urbanwood.repository.item.ItemRepository;
import br.sc.senac.urbanwood.repository.order.OrderRepository;
import br.sc.senac.urbanwood.repository.woodwork.WoodworkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;
    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final WoodworkRepository woodworkRepository;

    public ItemServiceImpl(ItemRepository itemRepository, ItemMapper itemMapper, OrderRepository orderRepository, ClientRepository clientRepository, WoodworkRepository woodworkRepository) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
        this.woodworkRepository = woodworkRepository;
    }

    public ItemDTO save(ItemDTO itemDTO) {

        Order order = orderRepository.findById(itemDTO.idOrder())
                .orElseThrow(() -> new OrderNotFoundException("Order " + itemDTO.idOrder() + " was not found"));

        Client client = clientRepository.findById(itemDTO.idClient())
                .orElseThrow(() -> new ClientNotFoundException("Client " + itemDTO.idClient() + " was not found"));

        Woodwork woodwork = woodworkRepository.findById(itemDTO.idWoodwork())
                .orElseThrow(() -> new WoodworkNotFoundException("Woodwork " + itemDTO.idWoodwork() + " was not found"));

        if (itemDTO.totalPrice() <= 0 || itemDTO.quantity() <= 0)
            throw new ItemInvalidException("Price is less than zero or Quantity is less than zero");

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