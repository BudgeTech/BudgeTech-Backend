package br.sc.senac.budgetech.backend.model.user;

import br.sc.senac.budgetech.backend.model.address.Address;
import br.sc.senac.budgetech.backend.model.contact.Contact;
import lombok.*;

import javax.persistence.*;
import java.sql.Blob;

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

    @Lob
    @Column(name = "user_image")
    private byte[] image;

    public User(Long id, String login, String password, byte[] image) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.image = image;
    }
}
