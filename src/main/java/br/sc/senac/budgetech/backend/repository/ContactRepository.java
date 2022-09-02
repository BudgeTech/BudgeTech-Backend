package br.sc.senac.budgetech.backend.repository;

import br.sc.senac.budgetech.backend.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);

    Optional<Contact> findContactById(Long id);

    Optional<Contact> findContactByPhoneNumber(String phoneNumber);
}
