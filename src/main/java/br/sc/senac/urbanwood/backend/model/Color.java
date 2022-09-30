package br.sc.senac.urbanwood.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "color")
public class Color {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_color")
	private Long id;

	@Column(name = "name_color", length = 45, nullable = false)
	private String nameColor;

	@Column(name = "brand_color", length = 45, nullable = false)
	private String brand;

	@ManyToOne
	@JoinColumn(name = "id_furniture")
	private Furniture furniture;

	public Color(Long id, String nameColor, String brand) {
		this.id = id;
		this.nameColor = nameColor;
		this.brand = brand;
	}
}
