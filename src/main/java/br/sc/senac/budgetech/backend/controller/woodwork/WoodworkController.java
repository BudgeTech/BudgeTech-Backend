package br.sc.senac.budgetech.backend.controller.woodwork;

import br.sc.senac.budgetech.backend.dto.woodwork.*;
import br.sc.senac.budgetech.backend.projection.woodwork.WoodworkProjection;
import br.sc.senac.budgetech.backend.service.woodwork.WoodworkService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/woodwork")
@AllArgsConstructor
public class WoodworkController {

    private final WoodworkService woodworkService;

    @PostMapping
    public ResponseEntity<WoodworkDTO> addWoodwork(@RequestBody WoodworkDTO woodworkDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(woodworkService.save(woodworkDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateWoodwork(@RequestBody WoodworkDTO woodworkDTO, @PathVariable(value = "id") Long id) {
        woodworkService.update(woodworkDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body("Woodwork updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWoodwork(@PathVariable(value = "id") Long id) {
        woodworkService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Woodwork deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<WoodworkProjection> getProjectionById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkService.findById(id));
    }

    @GetMapping("companyName/{companyName}")
    public ResponseEntity<WoodworkProjection> getProjectionByCompanyName(@PathVariable(value = "companyName") String companyName) {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkService.findByCompanyName(companyName));
    }

    @GetMapping("cnpj/{cnpj}")
    public ResponseEntity<WoodworkProjection> getProjectionByCnpj(@PathVariable(value = "cnpj") String cnpj) {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkService.findByCnpj(cnpj));
    }

    @GetMapping("neighborhood/{neighborhood}")
    public ResponseEntity<WoodworkProjection> getProjectionByAddressNeighborhood(@PathVariable(value = "neighborhood") String neighborhood) {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkService.findByAddressNeighborhood(neighborhood));
    }

    @GetMapping("phoneNumber/{phoneNumber}")
    public ResponseEntity<WoodworkProjection> getProjectionByContactPhoneNumber(@PathVariable(value = "phoneNumber") String phoneNumber) {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkService.findByContactPhoneNumber(phoneNumber));
    }

    @GetMapping("woodworkProfile/{id}")
    public ResponseEntity<WoodworkProfileDTO> getWoodworkProfileDTO(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkService.findProfileById(id));
    }

    @GetMapping("woodworkProfileEdit/{id}")
    public ResponseEntity<WoodworkProfileEditDTO> getWoodworkProfileEditDTO(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkService.findProfileEditById(id));
    }

    @GetMapping("woodworkProfileFullEdit/{id}")
    public ResponseEntity<WoodworkProfileFullEditDTO> getWoodworkProfileFullEditDTO(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkService.findProfileFullEditById(id));
    }

    @GetMapping("woodworkSearch/{id}")
    public ResponseEntity<WoodworkSearchDTO> getWoodworkSearch(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkService.findSearchById(id));
    }
}