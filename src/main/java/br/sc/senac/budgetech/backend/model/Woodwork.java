package br.sc.senac.budgetech.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "woodwork")
public class Woodwork extends User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_woodwork")
	private Long id;

	@Column(name = "company_name_woodwork", nullable = false)
	private String companyName;
	
	@Column(name = "cnpj_woodwork", nullable = false, unique = true)
	private String cnpj;

	@Column(name = "description_woodwork")
	private String description;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_contact")
	private Contact contact;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_address")
	private Address address;

	@OneToMany(mappedBy = "woodwork", cascade = CascadeType.ALL)
	private List<Item> items;

	@OneToMany(mappedBy = "woodwork", cascade = CascadeType.ALL)
	private List<LivingArea> livingAreas;

	public Woodwork() {
		items = new ArrayList<>();
		livingAreas = new ArrayList<>();
	}

	public Woodwork(String login, String password, Blob image, Long id, String companyName, String cnpj, String description) {
		super(login, password, image);
		this.id = id;
		this.companyName = companyName;
		this.cnpj = cnpj;
		this.description = description;
		items = new ArrayList<>();
		livingAreas = new ArrayList<>();
	}

	public void addItem(Item item) {
		this.items.add(item);
	}

	public void removeItem(Item item) {
		this.items.remove(item);
	}

	public List<Item> getItem() {
		return items;
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
}
