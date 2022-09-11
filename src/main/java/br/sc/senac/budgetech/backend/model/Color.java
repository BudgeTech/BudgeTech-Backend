package br.sc.senac.budgetech.backend.model;

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
	@Column(name = "color_id")
	private Long id;

	@Column(name = "color_name", length = 45, nullable = false)
	private String nameColor;

	@Column(name = "color_brand", length = 45, nullable = false)
	private String brand;

	@ManyToOne
	@JoinColumn(name = "furniture_id")
	private Furniture furniture;

	public Color(Long id, String nameColor, String brand) {
		this.id = id;
		this.nameColor = nameColor;
		this.brand = brand;
	}
}
