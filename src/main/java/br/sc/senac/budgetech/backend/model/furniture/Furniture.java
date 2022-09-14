package br.sc.senac.budgetech.backend.model.furniture;

import br.sc.senac.budgetech.backend.model.livingArea.LivingArea;
import br.sc.senac.budgetech.backend.model.request.Request;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
	@Column(name = "furniture_id")
	private Long id;

	@Column(name = "furniture_image")
	private Blob image;

	@Column(name = "furniture_name", length = 35, nullable = false)
	private String nameFurniture;

	@Column(name = "furniture_description")
	private String description;

	@Column(name = "furniture_size", length = 45, nullable = false)
	private Double furnitureSize;

	@Column(name = "furniture_price", length = 20, nullable = false)
	private Double priceFurniture;

	@ManyToOne
	@JoinColumn(name = "id_living_area")
	private LivingArea livingArea;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "request_furniture", joinColumns = @JoinColumn(name = "furniture_id"), inverseJoinColumns = @JoinColumn(name = "request_id"))
	private List<Request> requests;

	public Furniture() {
		requests = new ArrayList<>();
	}

	public Furniture(Long id, String nameFurniture, String description, Double furnitureSize, Double priceFurniture) {
		this.id = id;
		this.nameFurniture = nameFurniture;
		this.description = description;
		this.furnitureSize = furnitureSize;
		this.priceFurniture = priceFurniture;
		requests = new ArrayList<>();
	}

	public void addColor(Request request) {
		this.requests.add(request);
	}

	public void removeColor(Request request) {
		this.requests.remove(request);
	}

	@JsonBackReference
	public List<Request> getRequests() {
		return requests;
	}
}
