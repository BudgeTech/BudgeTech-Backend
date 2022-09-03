package br.sc.senac.budgetech.backend.controller;

import br.sc.senac.budgetech.backend.dto.FurnitureDTO;
import br.sc.senac.budgetech.backend.projection.FurnitureProjection;
import br.sc.senac.budgetech.backend.service.furniture.FurnitureService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/furniture")
@AllArgsConstructor
public class FurnitureController {

    private final FurnitureService furnitureService;

    @PostMapping
    public ResponseEntity<FurnitureDTO> addFurniture(@RequestBody FurnitureDTO furnitureDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(furnitureService.save(furnitureDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateFurniture(@RequestBody FurnitureDTO furnitureDTO, @PathVariable(value = "id") Long id) {
        furnitureService.update(furnitureDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body("Furniture updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFurniture(@PathVariable(value = "id") Long id) {
        furnitureService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Furniture deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<FurnitureProjection> getProjectionById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(furnitureService.findById(id));
    }

    @GetMapping("name/{name}")
    public ResponseEntity<FurnitureProjection> getProjectionByName(@PathVariable(value = "id") String name) {
        return ResponseEntity.status(HttpStatus.OK).body(furnitureService.findByName(name));
    }

    @GetMapping("price/{price}")
    public ResponseEntity<FurnitureProjection> getProjectionByPrice(@PathVariable(value = "id") double price) {
        return ResponseEntity.status(HttpStatus.OK).body(furnitureService.findByPrice(price));
    }
}