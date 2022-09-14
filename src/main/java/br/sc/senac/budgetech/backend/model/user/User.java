package br.sc.senac.budgetech.backend.model.user;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.sql.Blob;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@MappedSuperclass
public abstract class User {

    @Column(name = "user_login", length = 45, nullable = false, unique = true)
    private String login;

    @Column(name = "user_password", length = 45, nullable = false)
    private String password;

    @Column(name = "user_image")
    private Blob image;
}
