package br.sc.senac.budgetech.backend.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_image")
    private Image image;

    protected User(String password) {
        this.password =password;
    }
}
