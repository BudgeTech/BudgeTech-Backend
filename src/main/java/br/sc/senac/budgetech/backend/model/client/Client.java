package br.sc.senac.budgetech.backend.model.client;

import br.sc.senac.budgetech.backend.model.item.Item;
import br.sc.senac.budgetech.backend.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "client")
@PrimaryKeyJoinColumn(name="client_id", referencedColumnName="user_id")
public class Client extends User {

    @Column(name = "client_name", nullable = false)
    private String nameClient;

    @Column(name = "client_last_name", nullable = false)
    private String lastName;

    @Column(name = "client_cpf", length = 15, nullable = false, unique = true)
    private String cpf;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Item> items;

    public Client() {}

    public Client(Long id, String login, String password, byte[] image,String nameClient, String lastName, String cpf) {
        super(id, login, password, image);
        this.nameClient = nameClient;
        this.lastName = lastName;
        this.cpf = cpf;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }
}
