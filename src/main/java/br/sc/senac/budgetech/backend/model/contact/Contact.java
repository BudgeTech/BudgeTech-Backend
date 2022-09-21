package br.sc.senac.budgetech.backend.model.contact;

import br.sc.senac.budgetech.backend.model.client.Client;
import br.sc.senac.budgetech.backend.model.user.User;
import br.sc.senac.budgetech.backend.model.woodwork.Woodwork;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "contact")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contact_id")
	private Long id;

	@Column(name = "contact_email", length = 45, nullable = false, unique = true)
	private String email;

	@Column(name = "contact_phone_number", length = 30, nullable = false, unique = true)
	private String phoneNumber;

	@Column(name = "contact_social_network", length = 45)
	private String socialNetwork;

	@OneToOne(mappedBy = "contact")
	private Woodwork woodwork;

	@OneToOne(mappedBy = "contact")
	private Client client;

	public Contact(Long id, String email, String phoneNumber, String socialNetwork) {
		this.id = id;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.socialNetwork = socialNetwork;
	}
}
