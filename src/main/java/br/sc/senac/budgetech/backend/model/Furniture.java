package br.sc.senac.budgetech.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
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

	@ManyToOne
	@JoinColumn(name = "id_living_area")
	private LivingArea livingArea;

	@OneToMany(mappedBy = "furniture", cascade = CascadeType.ALL)
	private List<Color> colors;

	public Furniture() {
		colors = new ArrayList<>();
	}

	public Furniture(Long id, String name, String description, double furnitureSize, double price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.furnitureSize = furnitureSize;
		this.price = price;
		colors = new ArrayList<>();
	}

	public void addColor(Color color) {
		this.colors.add(color);
	}

	public void removeColor(Color color) {
		this.colors.remove(color);
	}

	public List<Color> getColor() {
		return colors;
	}
}
