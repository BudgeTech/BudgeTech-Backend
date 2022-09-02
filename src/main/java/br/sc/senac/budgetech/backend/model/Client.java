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

	@OneToOne
	@JoinColumn(name = "id_contact")
	private Contact contact;

	@OneToOne
	@JoinColumn(name = "id_address")
	private Address address;

	@OneToMany(mappedBy = "client")
	private List<Request> requests;

	public Client(String login, String password, Blob image, Long id, String name, String lastName, String cpf) {
		super(login, password, image);
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.cpf = cpf;
		requests = new ArrayList<>();
	}

	public void addRequest(Request request) {
		this.requests.add(request);
	}

	public void removeBudget(Request request) {
		this.requests.remove(request);
	}

	public List<Request> getBudget() {
		return requests;
	}
}
