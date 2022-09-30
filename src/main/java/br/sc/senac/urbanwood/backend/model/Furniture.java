package br.sc.senac.urbanwood.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Blob;
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

	@Column
	private Blob image;

	@Column(name = "name_furniture", length = 35, nullable = false)
	private String nameFurniture;

	@Column(name = "description_furniture")
	private String description;

	@Column(name = "furniture_size_furniture", length = 45, nullable = false)
	private double furnitureSize;

	@Column(name = "price_furniture", length = 20, nullable = false)
	private double priceFurniture;

	@ManyToOne
	@JoinColumn(name = "id_living_area")
	private LivingArea livingArea;

	@OneToMany(mappedBy = "furniture", cascade = CascadeType.ALL)
	private List<Color> colors;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "request_furniture", joinColumns = @JoinColumn(name = "id_furniture"), inverseJoinColumns = @JoinColumn(name = "id_request"))
	private List<Request> requests;

	public Furniture() {
		colors = new ArrayList<>();
		requests = new ArrayList<>();
	}

	public Furniture(Long id, String nameFurniture, String description, double furnitureSize, double priceFurniture) {
		this.id = id;
		this.nameFurniture = nameFurniture;
		this.description = description;
		this.furnitureSize = furnitureSize;
		this.priceFurniture = priceFurniture;
		colors = new ArrayList<>();
		requests = new ArrayList<>();
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

	public void addColor(Request request) {
		this.requests.add(request);
	}

	public void removeColor(Request request) {
		this.requests.remove(request);
	}

	public List<Request> getRequest() {
		return requests;
	}
}
