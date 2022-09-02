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
@Table(name = "woodwork")
public class Woodwork extends User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_woodwork")
	private Long id;

	@Column(name = "company_name_woodwork", length = 14, nullable = false)
	private String companyName;
	
	@Column(name = "cnpj_woodwork", length = 14, nullable = false, unique = true)
	private String cnpj;

	@Column(name = "description_woodwork")
	private String description;

	@OneToOne
	@JoinColumn(name = "id_contact")
	private Contact contact;

	@OneToOne
	@JoinColumn(name = "id_address")
	private Address address;

	@OneToMany(mappedBy = "woodwork")
	private List<Request> requests;

	@OneToMany(mappedBy = "woodwork")
	private List<LivingArea> livingAreas;

	@OneToMany(mappedBy = "woodwork")
	private List<Furniture> furnitures;

	public Woodwork(String login, String password, Blob image, Long id, String companyName, String cnpj, String description) {
		super(login, password, image);
		this.id = id;
		this.companyName = companyName;
		this.cnpj = cnpj;
		this.description = description;
		requests = new ArrayList<>();
		livingAreas = new ArrayList<>();
		furnitures = new ArrayList<>();
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

	public void addLivingArea(LivingArea livingArea) {
		this.livingAreas.add(livingArea);
	}

	public void removeLivingArea(LivingArea livingArea) {
		this.livingAreas.remove(livingArea);
	}

	public List<LivingArea> getLivingArea() {
		return livingAreas;
	}

	public void addFurniture(Furniture furniture) {
		this.furnitures.add(furniture);
	}

	public void removeFurniture(Furniture furniture) {
		this.furnitures.remove(furniture);
	}

	public List<Furniture> getFurniture() {
		return furnitures;
	}
}
