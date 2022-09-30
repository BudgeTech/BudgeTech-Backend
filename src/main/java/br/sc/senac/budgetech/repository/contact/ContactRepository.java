package br.sc.senac.budgetech.repository.contact;

import br.sc.senac.budgetech.model.contact.Contact;
import br.sc.senac.budgetech.projection.contact.ContactProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    Optional<ContactProjection> findContactById(Long id);

    Optional<ContactProjection> findContactByEmail(String email);

    Optional<ContactProjection> findContactByPhoneNumber(String phoneNumber);

    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);
}
