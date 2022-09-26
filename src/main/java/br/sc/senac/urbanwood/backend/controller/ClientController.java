package br.sc.senac.urbanwood.backend.controller;

import br.sc.senac.urbanwood.backend.dto.client.ClientDTO;
import br.sc.senac.urbanwood.backend.dto.client.ClientProfileEditDTO;
import br.sc.senac.urbanwood.backend.dto.client.ClientProfileFullEditDTO;
import br.sc.senac.urbanwood.backend.projection.client.*;
import br.sc.senac.urbanwood.backend.service.client.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/client")
@AllArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientDTO> addClient(@RequestBody ClientDTO clientDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(clientDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateClient(@RequestBody ClientDTO clientDTO, @PathVariable(value = "id") Long id) {
        clientService.update(clientDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body("Client updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable(value = "id") Long id) {
        clientService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Client deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientProjection> getProjectionById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findById(id));
    }

    @GetMapping("cpf/{cpf}")
    public ResponseEntity<ClientProjection> getProjectionByCpf(@PathVariable(value = "cpf") String cpf) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findByCpf(cpf));
    }

    @GetMapping("name/{nameClient}")
    public ResponseEntity<ClientProjection> getProjectionByName(@PathVariable(value = "nameClient") String nameClient) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findByNameClient(nameClient));
    }

    @GetMapping("phoneNumber/{phoneNumber}")
    public ResponseEntity<ClientProjection> getProjectionByContactPhoneNumber(@PathVariable(value = "phoneNumber") String phoneNumber) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findByContactPhoneNumber(phoneNumber));
    }

    @GetMapping("/{id}/address/contact")
    public ResponseEntity<ClientWithAddressAndContactProjection> getProjectionWithAddressAndContact(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findWithAddressAndContactById(id));
    }

    @GetMapping("/{id}/items")
    public ResponseEntity<ClientWithItemProjection> getProjectionWithItem(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findWithItemById(id));
    }

    @GetMapping("/{id}/all")
    public ResponseEntity<ClientWithAllProjection> getProjectionWithAll(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findWithAddressAndContactAndItemById(id));
    }

    @GetMapping("clientProfileEditDTO/{id}")
    public ResponseEntity<ClientProfileEditDTO> getProjectionClientProfileEditDTO(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findProfileEditById(id));
    }

    @GetMapping("clientProfileFullEditDTO/{id}")
    public ResponseEntity<ClientProfileFullEditDTO> getProjectionClientProfileFullEditDTO(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findProfileFullEditById(id));
    }
}