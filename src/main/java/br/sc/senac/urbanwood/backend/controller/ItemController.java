package br.sc.senac.urbanwood.backend.controller;

import br.sc.senac.urbanwood.backend.dto.item.ItemDTO;
import br.sc.senac.urbanwood.backend.projection.item.ItemProjection;
import br.sc.senac.urbanwood.backend.service.item.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/item")
@AllArgsConstructor
public class ItemController {

    private ItemService itemService;

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

    @GetMapping("totalPrice/{totalPrice}")
    public ResponseEntity<ItemProjection> getProjectionByPrice(@PathVariable(value = "id") double totalPrice) {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.findByPrice(totalPrice));
    }
}
