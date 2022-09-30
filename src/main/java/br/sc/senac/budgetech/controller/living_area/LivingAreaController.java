package br.sc.senac.budgetech.controller.living_area;

import br.sc.senac.budgetech.dto.living_area.LivingAreaDTO;
import br.sc.senac.budgetech.projection.living_area.LivingAreaProjection;
import br.sc.senac.budgetech.projection.living_area.screen.LivingAreaProjectionC16;
import br.sc.senac.budgetech.service.living_area.LivingAreaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/livingArea")
public class LivingAreaController {

    private final LivingAreaService livingAreaService;

    public LivingAreaController(LivingAreaService livingAreaService) {
        this.livingAreaService = livingAreaService;
    }

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

    @GetMapping("name/{nameLivingArea}")
    public ResponseEntity<List<LivingAreaProjection>> getProjectionByName(@PathVariable(value = "nameLivingArea") String nameLivingArea) {
        return ResponseEntity.status(HttpStatus.OK).body(livingAreaService.findByNameLivingArea(nameLivingArea));
    }

    /*          |||
      Screen    |||
      Screen    |||
      Screen    vvv
     */

    //Approved
    @GetMapping("c16")
    public ResponseEntity<List<LivingAreaProjectionC16>> getProjectionC16OrderByName() {
        return ResponseEntity.status(HttpStatus.OK).body(livingAreaService.findC16OrderByName());
    }
}
