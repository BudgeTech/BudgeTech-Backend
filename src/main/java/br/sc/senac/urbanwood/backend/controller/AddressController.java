package br.sc.senac.urbanwood.backend.controller;

import br.sc.senac.urbanwood.backend.dto.address.AddressDTO;
import br.sc.senac.urbanwood.backend.projection.address.AddressProjection;
import br.sc.senac.urbanwood.backend.service.address.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/address")
@AllArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<AddressDTO> addAddress(@RequestBody AddressDTO addressDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.save(addressDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAddress(@RequestBody AddressDTO addressDTO, @PathVariable(value = "id") Long id) {
        addressService.update(addressDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body("Address updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable(value = "id") Long id) {
        addressService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Address deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressProjection> getProjectionById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.findById(id));
    }

    @GetMapping("neighbor/{neighbor}")
    public ResponseEntity<AddressProjection> getProjectionByNeighbor(@PathVariable(value = "neighbor") String neighbor) {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.findByNeighbor(neighbor));
    }

    @GetMapping("city/{city}")
    public ResponseEntity<AddressProjection> getProjectionByCity(@PathVariable(value = "city") String city) {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.findByCity(city));
    }
}