package br.sc.senac.budgetech.backend.controller;

import br.sc.senac.budgetech.backend.dto.ClientDTO;
import br.sc.senac.budgetech.backend.projection.ClientAllProjection;
import br.sc.senac.budgetech.backend.projection.ClientProjection;
import br.sc.senac.budgetech.backend.projection.WoodworkAllProjection;
import br.sc.senac.budgetech.backend.projection.WoodworkProjection;
import br.sc.senac.budgetech.backend.service.client.ClientService;
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

    @GetMapping("name/{name}")
    public ResponseEntity<ClientProjection> getProjectionByName(@PathVariable(value = "name") String name) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findByName(name));
    }

    @GetMapping("phoneNumber/{phoneNumber}")
    public ResponseEntity<ClientProjection> getProjectionByContactPhoneNumber(@PathVariable(value = "phoneNumber") String phoneNumber) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findByContactPhoneNumber(phoneNumber));
    }

    @GetMapping("/{id}/all")
    public ResponseEntity<ClientAllProjection> getProjectionWithAddressAndContact(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findWithAddressAndContactById(id));
    }
}