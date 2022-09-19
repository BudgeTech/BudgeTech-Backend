package br.sc.senac.budgetech.backend.model.user;

import br.sc.senac.budgetech.backend.model.address.Address;
import br.sc.senac.budgetech.backend.model.contact.Contact;
import lombok.*;

import javax.persistence.*;
import java.sql.Blob;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    protected Long id;

    @Column(name = "user_login", length = 45, nullable = false)
    private String login;

    @Column(name = "user_password", length = 45, nullable = false)
    private String password;

    @Column(name = "user_image")
    private Blob image;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    public User(Long id, String login, String password, Blob image) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.image = image;
    }
}
