package br.sc.senac.urbanwood.controller.client;

import br.sc.senac.urbanwood.dto.client.ClientDTO;
import br.sc.senac.urbanwood.projection.client.ClientProjection;
import br.sc.senac.urbanwood.projection.client.screen.*;
import br.sc.senac.urbanwood.service.client.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

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

    /*          |||
      Screen    |||
      Screen    |||
      Screen    vvv
     */

    //Approved
    @GetMapping("w9/{page}")
    public ResponseEntity<Page<ClientProjectionW9>> getProjectionW9ByName(@PathVariable(value = "page") Integer page, Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findW9ByNameClient(pageable, page));
    }

    //Approved
    @GetMapping("w10/{id}")
    public ResponseEntity<ClientProjectionW10> getProjectionW10ById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findW10ById(id));
    }


    //Error
    @GetMapping("c13/{id}")
    public ResponseEntity<ClientProjectionC13> getProjectionC13ById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findC13ById(id));
    }

    //Approved
    @GetMapping("c6/{id}")
    public ResponseEntity<ClientProjectionC6> getProjectionC6ById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findC6ById(id));
    }

    //Approved
    @GetMapping("c7/{id}")
    public ResponseEntity<ClientProjectionC7> getProjectionC7ById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findC7ById(id));
    }
}