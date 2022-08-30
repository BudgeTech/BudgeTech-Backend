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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "furniture")
public class Furniture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_furniture")
	private Long id;

	@Column(name = "name_furniture", length = 35, nullable = false)
	private String name;

	@Column(name = "description_furniture")
	private String description;

	@Column(name = "furniture_size_furniture", length = 45, nullable = false)
	private double furnitureSize;

	@Column(name = "price_furniture", length = 20, nullable = false)
	private double price;
	
	@Column(name = "quantity_request", nullable = false)
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name = "id_woodwork")
	private Woodwork woodwork;

	@ManyToOne
	@JoinColumn(name = "id_living_area")
	private LivingArea livingArea;

	@ManyToOne
	@JoinColumn(name = "id_request")
	private Request request;

	@OneToMany(mappedBy = "furniture")
	private List<Color> colors;
}
