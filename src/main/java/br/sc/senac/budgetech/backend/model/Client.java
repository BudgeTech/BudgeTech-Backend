package br.sc.senac.budgetech.backend.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import antlr.collections.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Client")
public class Client extends User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_client")
	private Long id;

	@Column(name = "cpf_client", length = 15, nullable = false, unique = true)
	private String cpf;

	@Column(name = "name_client", nullable = false)
	private String name;

	@Column(name = "last_name_client", nullable = false)
	private String lastName;

	@OneToOne
	@JoinColumn(name = "id_contact")
	private Contact contact;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_address")
	private Address address;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "client")
	private List<Budget> budgets;

}
