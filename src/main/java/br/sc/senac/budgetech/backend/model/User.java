package br.sc.senac.budgetech.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.sql.Blob;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class User {

    @Column(name = "login_user", length = 45, nullable = false, unique = true)
    private String login;

    @Column(name = "password_user", length = 45, nullable = false)
    private String password;

    @Column(name = "image_user")
    private Blob image;
}
