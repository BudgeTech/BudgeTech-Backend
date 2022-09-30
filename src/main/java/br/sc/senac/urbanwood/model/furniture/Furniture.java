package br.sc.senac.urbanwood.model.furniture;

import br.sc.senac.urbanwood.model.color.Color;
import br.sc.senac.urbanwood.model.living_area.LivingArea;
import br.sc.senac.urbanwood.model.order.Order;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "furniture")
public class Furniture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "furniture_id")
	private Long id;

	@Lob
	@Column(name = "furniture_image")
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

	@ManyToMany(mappedBy = "furnitures", cascade = CascadeType.ALL)
	private List<Order> orders;

	public Furniture() {
		orders = new ArrayList<>();
		colors = new ArrayList<>();
	}

	public Furniture(Long id, String nameFurniture, String description, Double furnitureSize, Double priceFurniture) {
		this.id = id;
		this.nameFurniture = nameFurniture;
		this.description = description;
		this.furnitureSize = furnitureSize;
		this.priceFurniture = priceFurniture;
		orders = new ArrayList<>();
		colors = new ArrayList<>();
	}

	@JsonBackReference
	public List<Order> getOrders() {
		return orders;
	}

	public void addColor(Color color) {
		this.colors.add(color);
	}

	public void removeColor(Color color) {
		this.colors.remove(color);
	}

	public List<Color> getColors() {
		return colors;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getNameFurniture() {
		return nameFurniture;
	}

	public void setNameFurniture(String nameFurniture) {
		this.nameFurniture = nameFurniture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getFurnitureSize() {
		return furnitureSize;
	}

	public void setFurnitureSize(Double furnitureSize) {
		this.furnitureSize = furnitureSize;
	}

	public Double getPriceFurniture() {
		return priceFurniture;
	}

	public void setPriceFurniture(Double priceFurniture) {
		this.priceFurniture = priceFurniture;
	}

	public LivingArea getLivingArea() {
		return livingArea;
	}

	public void setLivingArea(LivingArea livingArea) {
		this.livingArea = livingArea;
	}

	public void setColors(List<Color> colors) {
		this.colors = colors;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}
