package br.sc.senac.urbanwood.controller.item;

import br.sc.senac.urbanwood.dto.item.ItemDTO;
import br.sc.senac.urbanwood.projection.item.ItemProjection;
import br.sc.senac.urbanwood.service.item.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<ItemDTO> addItem(@RequestBody ItemDTO itemDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.save(itemDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateItem(@RequestBody ItemDTO itemDTO, @PathVariable(value = "id") Long id) {
        itemService.update(itemDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body("Item updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable(value = "id") Long id) {
        itemService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Item deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemProjection> getProjectionById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.findById(id));
    }

    @GetMapping("price/{totalPrice}")
    public ResponseEntity<List<ItemProjection>> getProjectionByPrice(@PathVariable(value = "totalPrice") Double totalPrice) {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.findByPrice(totalPrice));
    }
}
