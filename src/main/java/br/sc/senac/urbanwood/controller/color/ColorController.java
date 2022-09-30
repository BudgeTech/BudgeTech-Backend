package br.sc.senac.urbanwood.controller.color;

import br.sc.senac.urbanwood.dto.color.ColorDTO;
import br.sc.senac.urbanwood.projection.color.ColorProjection;
import br.sc.senac.urbanwood.service.color.ColorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/color")
public class ColorController {

    private final ColorService colorService;

    public ColorController(ColorService colorService) {
        this.colorService = colorService;
    }

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
    public ResponseEntity<List<ColorProjection>> getProjectionByName(@PathVariable(value = "nameColor") String nameColor) {
        return ResponseEntity.status(HttpStatus.OK).body(colorService.findByNameColor(nameColor));
    }

    @GetMapping("brand/{brand}")
    public ResponseEntity<List<ColorProjection>> getProjectionByBrand(@PathVariable(value = "brand") String brand) {
        return ResponseEntity.status(HttpStatus.OK).body(colorService.findByBrand(brand));
    }
}