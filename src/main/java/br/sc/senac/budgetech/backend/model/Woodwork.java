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

}
