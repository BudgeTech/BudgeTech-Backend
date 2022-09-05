package br.sc.senac.budgetech.backend.controller;

import br.sc.senac.budgetech.backend.dto.LivingAreaDTO;
import br.sc.senac.budgetech.backend.projection.LivingAreaProjection;
import br.sc.senac.budgetech.backend.service.living_area.LivingAreaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/livingArea")
@AllArgsConstructor
public class LivingAreaController {

    private LivingAreaService livingAreaService;

    @PostMapping
    public ResponseEntity<LivingAreaDTO> addLivingArea(@RequestBody LivingAreaDTO livingAreaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(livingAreaService.save(livingAreaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateLivingArea(@RequestBody LivingAreaDTO livingAreaDTO, @PathVariable(value = "id") Long id) {
        livingAreaService.update(livingAreaDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body("Living Area updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLivingArea(@PathVariable(value = "id") Long id) {
        livingAreaService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Living Area deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivingAreaProjection> getProjectionById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(livingAreaService.findById(id));
    }

    @GetMapping("name/{name}")
    public ResponseEntity<LivingAreaProjection> getProjectionByName(@PathVariable(value = "name") String name) {
        return ResponseEntity.status(HttpStatus.OK).body(livingAreaService.findByName(name));
    }
}
