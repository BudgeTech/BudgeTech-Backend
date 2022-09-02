package br.sc.senac.budgetech.backend.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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
	private String name;

	@Column(name = "brand_color", length = 45, nullable = false)
	private String brand;

	@ManyToOne
	@JoinColumn(name = "id_furniture")
	private Furniture furniture;

	public Color(Long id, String name, String brand) {
		this.id = id;
		this.name = name;
		this.brand = brand;
	}
}
