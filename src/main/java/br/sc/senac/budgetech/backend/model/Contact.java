package br.sc.senac.budgetech.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Contact")
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

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "contact")
	private Client client;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "contact")
	private Woodwork woodwork;
}
