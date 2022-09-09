package br.sc.senac.budgetech.backend.controller;

import br.sc.senac.budgetech.backend.dto.woodwork.WoodworkProfileDTO;
import br.sc.senac.budgetech.backend.dto.woodwork.WoodworkDTO;
import br.sc.senac.budgetech.backend.dto.woodwork.WoodworkProfileEditDTO;
import br.sc.senac.budgetech.backend.dto.woodwork.WoodworkProfileFullEditDTO;
import br.sc.senac.budgetech.backend.projection.woodwork.WoodworkWithAddressAndContactProjection;
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

    @GetMapping("login/{login}")
    public ResponseEntity<WoodworkProjection> getProjectionByLogin(@PathVariable(value = "login") String login) {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkService.findByLogin(login));
    }

    @GetMapping("neighbor/{neighbor}")
    public ResponseEntity<WoodworkProjection> getProjectionByAddressNeighbor(@PathVariable(value = "neighbor") String neighbor) {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkService.findByAddressNeighbor(neighbor));
    }

    @GetMapping("phoneNumber/{phoneNumber}")
    public ResponseEntity<WoodworkProjection> getProjectionByContactPhoneNumber(@PathVariable(value = "phoneNumber") String phoneNumber) {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkService.findByContactPhoneNumber(phoneNumber));
    }

    @GetMapping("/{id}/all")
    public ResponseEntity<WoodworkWithAddressAndContactProjection> getProjectionWithAddressAndContact(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkService.findWithAddressAndContactById(id));
    }

    @GetMapping("woodworkProfile/{id}")
    public ResponseEntity<WoodworkProfileDTO> getProjectionWoodworkProfile(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkService.findProfileById(id));
    }

    @GetMapping("woodworkProfileEditDTO/{id}")
    public ResponseEntity<WoodworkProfileEditDTO> getProjectionWoodworkProfileEditDTO(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkService.findProfileEditById(id));
    }

    @GetMapping("woodworkProfileFullEditDTO/{id}")
    public ResponseEntity<WoodworkProfileFullEditDTO> getProjectionWoodworkProfileFullEditDTO(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(woodworkService.findProfileFullEditById(id));
    }

    //asdad
}