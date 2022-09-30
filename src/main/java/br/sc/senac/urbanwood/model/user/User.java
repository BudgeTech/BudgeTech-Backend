package br.sc.senac.urbanwood.model.user;

import javax.persistence.*;

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

    public User() {
    }

    public User(Long id, String login, String password, byte[] image) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
