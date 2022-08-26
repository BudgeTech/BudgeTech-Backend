package br.sc.senac.budgetech.backend.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Furniture")
public class Furniture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_furniture")
	private Long id;

	@Column(name = "name_furniture", length = 35, nullable = false)
	private String name;

	@Column(name = "description_furniture")
	private String description;

	@Column(name = "footage_furniture", length = 45, nullable = false)
	private double footage;

	@Column(name = "price_furniture", length = 20, nullable = false)
	private double price;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_woodwork")
	private Woodwork woodwork;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_color")
	private Color color;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_environment")
	private Environment environment;

	@ManyToOne
	@JoinColumn(name = "id_request")
	private Request request;
}
