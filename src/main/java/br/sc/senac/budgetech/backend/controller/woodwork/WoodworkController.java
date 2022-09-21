package br.sc.senac.budgetech.backend.controller.woodwork;

import br.sc.senac.budgetech.backend.dto.woodwork.*;
import br.sc.senac.budgetech.backend.projection.woodwork.*;
import br.sc.senac.budgetech.backend.service.woodwork.WoodworkService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("cnpj/{cnpj}")
    public ResponseEntity<WoodworkProjection> getProjectionByCnpj(@PathVariable(value = "cnpj") String cnpj) {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkService.findByCnpj(cnpj));
    }

    @GetMapping("neighborhood/{neighborhood}")
    public ResponseEntity<WoodworkProjection> getProjectionByNeighborhood(@PathVariable(value = "neighborhood") String neighborhood) {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkService.findByAddressNeighborhood(neighborhood));
    }

    @GetMapping("phoneNumber/{phoneNumber}")
    public ResponseEntity<WoodworkProjection> getProjectionByPhoneNumber(@PathVariable(value = "phoneNumber") String phoneNumber) {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkService.findByContactPhoneNumber(phoneNumber));
    }

    @GetMapping("companyName/{companyName}")
    public ResponseEntity<WoodworkProjection> getProjectionByCompanyName(@PathVariable(value = "companyName") String companyName) {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkService.findByCompanyName(companyName));
    }

    @GetMapping("woodworkSearch20")
    public ResponseEntity<List<WoodworkSearchProjection20>> getWoodworkSearchById() {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkService.findSearchBy());
    }

    @GetMapping("woodworkProfile")
    public ResponseEntity<WoodworkProfileProjection> getWoodworkProfileById() {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkService.findProfileBy());
    }

    @GetMapping("woodworkProfileEdit")
    public ResponseEntity<WoodworkProfileEditProjection> getWoodworkProfileEditById() {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkService.findProfileEditBy());
    }

    @GetMapping("woodworkProfileFullEdit")
    public ResponseEntity<WoodworkProfileFullEditProjection> getWoodworkProfileFullEditById() {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkService.findProfileFullEditBy());
    }

    @GetMapping("woodwork21")
    public ResponseEntity<WoodworkFulProjection21> getWoodworkProjection21ById() {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkService.findProjection21By());
    }
}