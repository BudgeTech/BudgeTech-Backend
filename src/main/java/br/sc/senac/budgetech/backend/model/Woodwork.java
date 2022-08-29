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


import org.hibernate.cfg.Environment;

import antlr.collections.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "woodwork")
	private Address address;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "woodwork")
	private List request;

	@OneToMany(mappedBy = "woodwork")
	private List livingArea;

}
