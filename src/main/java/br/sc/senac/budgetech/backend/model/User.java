package br.sc.senac.budgetech.backend.model;

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

    @Column(name = "login_user", length = 45, nullable = false, unique = true)
    private String login;

    @Column(name = "password_user", length = 45, nullable = false)
    private String password;

    @Column(name = "image_user")
    private Blob image;
}
