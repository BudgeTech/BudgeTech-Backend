package br.sc.senac.urbanwood.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "client")
public class Client extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Long id;

    @Column(name = "name_client", nullable = false)
    private String nameClient;

    @Column(name = "last_name_client", nullable = false)
    private String lastName;

    @Column(name = "cpf_client", length = 15, nullable = false, unique = true)
    private String cpf;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_contact")
    private Contact contact;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address")
    private Address address;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Item> items;

    public Client() {
        items = new ArrayList<>();
    }

    public Client(String login, String password, Blob image, Long id, String nameClient, String lastName, String cpf) {
        super(login, password, image);
        this.id = id;
        this.nameClient = nameClient;
        this.lastName = lastName;
        this.cpf = cpf;
        items = new ArrayList<>();
    }

    public Client(String password, String email) {
        super(password);
        email = getContact().getEmail();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public List<Item> getItem() {
        return items;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
