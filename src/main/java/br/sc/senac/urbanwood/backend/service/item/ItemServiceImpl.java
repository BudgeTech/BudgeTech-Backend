package br.sc.senac.urbanwood.backend.service.item;

import br.sc.senac.urbanwood.backend.dto.item.ItemDTO;
import br.sc.senac.urbanwood.backend.exception.client.ClientNotFoundException;
import br.sc.senac.urbanwood.backend.exception.item.ItemInvalidException;
import br.sc.senac.urbanwood.backend.exception.item.ItemNotFoundException;
import br.sc.senac.urbanwood.backend.exception.request.RequestNotFoundException;
import br.sc.senac.urbanwood.backend.exception.woodwork.WoodworkNotFoundException;
import br.sc.senac.urbanwood.backend.mapper.ItemMapper;
import br.sc.senac.urbanwood.backend.model.Client;
import br.sc.senac.urbanwood.backend.model.Item;
import br.sc.senac.urbanwood.backend.model.Request;
import br.sc.senac.urbanwood.backend.model.Woodwork;
import br.sc.senac.urbanwood.backend.projection.item.ItemProjection;
import br.sc.senac.urbanwood.backend.repository.ClientRepository;
import br.sc.senac.urbanwood.backend.repository.ItemRepository;
import br.sc.senac.urbanwood.backend.repository.RequestRepository;
import br.sc.senac.urbanwood.backend.repository.WoodworkRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;
    private ItemMapper itemMapper;
    private RequestRepository requestRepository;
    private ClientRepository clientRepository;
    private WoodworkRepository woodworkRepository;

    public ItemDTO save(ItemDTO itemDTO) {

        Request request = requestRepository.findById(itemDTO.idRequest())
                .orElseThrow(() -> new RequestNotFoundException("Request " + itemDTO.idRequest() + " was not found"));

        Client client = clientRepository.findById(itemDTO.idClient())
                .orElseThrow(() -> new ClientNotFoundException("Client " + itemDTO.idClient() + " was not found"));

        Woodwork woodwork = woodworkRepository.findById(itemDTO.idWoodwork())
                .orElseThrow(() -> new WoodworkNotFoundException("Woodwork " + itemDTO.idWoodwork() + " was not found"));

        if (itemDTO.totalPrice() < 0)
            throw new ItemInvalidException("Total Price " + itemDTO.totalPrice() + " is invalid");

        if (itemDTO.quantity() < 0)
            throw new ItemInvalidException("Quantity " + itemDTO.quantity() + " is invalid");

        Item item = itemMapper.toEntity(itemDTO);
        item.setRequest(request);
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

    public ItemProjection findByPrice(double totalPrice) {
        return itemRepository.findItemByTotalPrice(totalPrice)
                .orElseThrow(() -> new ItemNotFoundException("Item " + totalPrice + " was not found"));
    }
}