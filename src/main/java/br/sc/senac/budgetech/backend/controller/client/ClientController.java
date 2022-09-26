package br.sc.senac.budgetech.backend.controller.client;

import br.sc.senac.budgetech.backend.dto.client.ClientDTO;
import br.sc.senac.budgetech.backend.projection.client.ClientListProjectionW9;
import br.sc.senac.budgetech.backend.projection.client.ClientListW10;
import br.sc.senac.budgetech.backend.projection.client.ClientProjection;
import br.sc.senac.budgetech.backend.service.client.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<List<ClientProjection>> getProjectionByName(@PathVariable(value = "nameClient") String nameClient) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findByNameClient(nameClient));
    }

    @GetMapping("phoneNumber/{phoneNumber}")
    public ResponseEntity<ClientProjection> getProjectionByPhoneNumber(@PathVariable(value = "phoneNumber") String phoneNumber) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findByContactPhoneNumber(phoneNumber));
    }

    @GetMapping("clientProfileW10")
    public ResponseEntity<ClientListW10> getProjectionClientProfileFullEditBy() {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findProfileFullEditBy());
    }

    //Arrumar Repository, outras classes retornando null
    @GetMapping("paginationName/{page}")
    public ResponseEntity<Page<ClientListProjectionW9>> getProjectionWithPaginationAndSortingById(@PathVariable(value = "page") Integer page, Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findWithPaginationAndSortingByClientId(pageable, page));
    }
}