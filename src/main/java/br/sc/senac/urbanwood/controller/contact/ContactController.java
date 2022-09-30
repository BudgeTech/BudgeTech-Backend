package br.sc.senac.urbanwood.controller.contact;

import br.sc.senac.urbanwood.dto.contact.ContactDTO;
import br.sc.senac.urbanwood.projection.contact.ContactProjection;
import br.sc.senac.urbanwood.service.contact.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/contact")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

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
    public ResponseEntity<ContactProjection> getProjectionById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(contactService.findById(id));
    }

    @GetMapping("email/{email}")
    public ResponseEntity<ContactProjection> getProjectionByEmail(@PathVariable(value = "email") String email) {
        return ResponseEntity.status(HttpStatus.OK).body(contactService.findByEmail(email));
    }

    @GetMapping("phoneNumber/{phoneNumber}")
    public ResponseEntity<ContactProjection> getProjectionByPhoneNumber(@PathVariable(value = "phoneNumber") String phoneNumber) {
        return ResponseEntity.status(HttpStatus.OK).body(contactService.findByPhoneNumber(phoneNumber));
    }
}