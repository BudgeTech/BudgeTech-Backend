package br.sc.senac.budgetech.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

}
