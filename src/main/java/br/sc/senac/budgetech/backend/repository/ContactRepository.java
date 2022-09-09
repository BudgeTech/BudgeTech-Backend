package br.sc.senac.budgetech.backend.repository;

import br.sc.senac.budgetech.backend.model.Contact;
import br.sc.senac.budgetech.backend.projection.contact.ContactProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);

    Optional<ContactProjection> findContactById(Long id);

    Optional<ContactProjection> findContactByPhoneNumber(String phoneNumber);
}
