package br.sc.senac.budgetech.backend.controller;

import br.sc.senac.budgetech.backend.dto.contact.ContactDTO;
import br.sc.senac.budgetech.backend.projection.contact.ContactProjection;
import br.sc.senac.budgetech.backend.service.contact.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/contact")
@AllArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @PostMapping
    public ResponseEntity<ContactDTO> addContact(@RequestBody ContactDTO contactDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contactService.save(contactDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateContact(@RequestBody ContactDTO contactDTO, @PathVariable(value = "id") Long id) {
        contactService.update(contactDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body("Contact updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable(value = "id") Long id) {
        contactService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Contact deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactProjection> getProjectionByPhoneNumber(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(contactService.findById(id));
    }

    @GetMapping("phoneNumber/{phoneNumber}")
    public ResponseEntity<ContactProjection> getProjectionByPhoneNumber(@PathVariable(value = "phoneNumber") String phoneNumber) {
        return ResponseEntity.status(HttpStatus.OK).body(contactService.findByPhoneNumber(phoneNumber));
    }
}