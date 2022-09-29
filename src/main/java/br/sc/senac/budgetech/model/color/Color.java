package br.sc.senac.budgetech.model.color;

import br.sc.senac.budgetech.model.furniture.Furniture;

import javax.persistence.*;

@Entity
@Table(name = "color")
public class Color {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "color_id")
	private Long id;

	@Column(name = "color_name", length = 45, nullable = false)
	private String nameColor;

	@Column(name = "color_brand", length = 45, nullable = false)
	private String brand;

	@ManyToOne
	@JoinColumn(name = "furniture_id")
	private Furniture furniture;

	public Color() {
	}

	public Color(Long id, String nameColor, String brand) {
		this.id = id;
		this.nameColor = nameColor;
		this.brand = brand;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameColor() {
		return nameColor;
	}

	public void setNameColor(String nameColor) {
		this.nameColor = nameColor;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Furniture getFurniture() {
		return furniture;
	}

	public void setFurniture(Furniture furniture) {
		this.furniture = furniture;
	}
}
