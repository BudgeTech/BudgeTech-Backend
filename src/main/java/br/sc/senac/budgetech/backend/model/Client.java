package br.sc.senac.budgetech.backend.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "client")
public class Client extends User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_client")
	private Long id;

	@Column(name = "name_client", nullable = false)
	private String name;

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

	public Client(String login, String password, Blob image, Long id, String name, String lastName, String cpf) {
		super(login, password, image);
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.cpf = cpf;
		items = new ArrayList<>();
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
}
