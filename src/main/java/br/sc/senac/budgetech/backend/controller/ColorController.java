package br.sc.senac.budgetech.backend.controller;

import br.sc.senac.budgetech.backend.dto.color.ColorDTO;
import br.sc.senac.budgetech.backend.projection.color.ColorProjection;
import br.sc.senac.budgetech.backend.service.color.ColorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/color")
@AllArgsConstructor
public class ColorController {

    private final ColorService colorService;

    @PostMapping
    public ResponseEntity<ColorDTO> addColor(@RequestBody ColorDTO colorDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(colorService.save(colorDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateColor(@RequestBody ColorDTO colorDTO, @PathVariable(value = "id") Long id) {
        colorService.update(colorDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body("Color updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteColor(@PathVariable(value = "id") Long id) {
        colorService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Color deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ColorProjection> getProjectionById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(colorService.findById(id));
    }

    @GetMapping("name/{nameColor}")
    public ResponseEntity<ColorProjection> getProjectionByNameColor(@PathVariable(value = "nameColor") String nameColor) {
        return ResponseEntity.status(HttpStatus.OK).body(colorService.findByNameColor(nameColor));
    }

    @GetMapping("brand/{brand}")
    public ResponseEntity<ColorProjection> getProjectionByBrand(@PathVariable(value = "brand") String brand) {
        return ResponseEntity.status(HttpStatus.OK).body(colorService.findByBrand(brand));
    }
}