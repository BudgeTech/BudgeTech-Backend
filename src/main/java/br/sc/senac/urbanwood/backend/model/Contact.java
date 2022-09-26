package br.sc.senac.urbanwood.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contact")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contact")
	private Long id;

	@Column(name = "email_contact", length = 45, nullable = false, unique = true)
	private String email;

	@Column(name = "phone_number_contact", length = 30, nullable = false, unique = true)
	private String phoneNumber;

	@Column(name = "social_network_contact", length = 45)
	private String socialNetwork;

	@OneToOne(mappedBy = "contact")
	private Client client;

	@OneToOne(mappedBy = "contact")
	private Woodwork woodwork;

	public Contact(String email) {
		this.email = email;
	}

	public Contact(Long id, String email, String phoneNumber, String socialNetwork) {
		this.id = id;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.socialNetwork = socialNetwork;
	}
}
