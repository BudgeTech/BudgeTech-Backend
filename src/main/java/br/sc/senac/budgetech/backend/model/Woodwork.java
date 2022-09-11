package br.sc.senac.budgetech.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Blob;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "woodwork")
public class Woodwork extends User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "woodwork_id")
	private Long id;

	@Column(name = "woodwork_company_name", nullable = false)
	private String companyName;
	
	@Column(name = "woodwork_cnpj", nullable = false, unique = true)
	private String cnpj;

	@Column(name = "woodwork_description")
	private String description;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "contact_id")
	private Contact contact;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;

	public Woodwork(String login, String password, Blob image, Long id, String companyName, String cnpj, String description) {
		super(login, password, image);
		this.id = id;
		this.companyName = companyName;
		this.cnpj = cnpj;
		this.description = description;
	}
}
