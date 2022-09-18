package br.sc.senac.budgetech.backend.model.furniture;

import br.sc.senac.budgetech.backend.model.color.Color;
import br.sc.senac.budgetech.backend.model.livingArea.LivingArea;
import br.sc.senac.budgetech.backend.model.request.Request;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
	@Column(name = "furniture_id")
	private Long id;

	@Column(name = "furniture_image")
	@Lob
	private byte[] image;

	@Column(name = "furniture_name", length = 35, nullable = false)
	private String nameFurniture;

	@Column(name = "furniture_description")
	private String description;

	@Column(name = "furniture_size", length = 45, nullable = false)
	private Double furnitureSize;

	@Column(name = "furniture_price", length = 20, nullable = false)
	private Double priceFurniture;

	@ManyToOne
	@JoinColumn(name = "living_area_id")
	private LivingArea livingArea;

	@OneToMany(mappedBy = "furniture", cascade = CascadeType.ALL)
	private List<Color> colors;

	@ManyToMany(mappedBy = "furnitures")
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

	@JsonBackReference
	public List<Request> getRequests() {
		return requests;
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
