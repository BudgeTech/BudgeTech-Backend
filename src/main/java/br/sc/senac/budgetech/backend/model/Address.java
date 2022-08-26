package br.sc.senac.budgetech.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "Address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_address")
	private Long id;

	@Column(name = "cep_address", nullable = false)
	private String cep;

	@Column(name = "number_address", nullable = false)
	private int number;

	@Column(name = "province_address", length = 45, nullable = false)
	private String district;

	@Column(name = "city_address", length = 45, nullable = false)
	private String city;

	@Column(name = "street_name_address", length = 45, nullable = false)
	private String road;

	@Column(name = "complement_address", length = 45, nullable = false)
	private String complement;

	@OneToOne(mappedBy = "address")
	private Client client;

	@OneToOne(mappedBy = "address")
	private Woodwork woodwork;

}
