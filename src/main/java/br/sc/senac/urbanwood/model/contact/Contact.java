package br.sc.senac.urbanwood.model.contact;

import br.sc.senac.urbanwood.model.client.Client;
import br.sc.senac.urbanwood.model.woodwork.Woodwork;

import javax.persistence.*;

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

	public Contact() {
	}

	public Contact(Long id, String email, String phoneNumber, String socialNetwork) {
		this.id = id;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.socialNetwork = socialNetwork;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSocialNetwork() {
		return socialNetwork;
	}

	public void setSocialNetwork(String socialNetwork) {
		this.socialNetwork = socialNetwork;
	}

	public Woodwork getWoodwork() {
		return woodwork;
	}

	public void setWoodwork(Woodwork woodwork) {
		this.woodwork = woodwork;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
