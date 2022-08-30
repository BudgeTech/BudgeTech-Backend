package br.sc.senac.budgetech.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
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

	@Column(name = "social_media_contact", length = 45)
	private String socialNetwork;

	@OneToOne(mappedBy = "contact")
	private Client client;

	@OneToOne(mappedBy = "contact")
	private Woodwork woodwork;
}
