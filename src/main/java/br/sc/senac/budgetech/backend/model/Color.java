package br.sc.senac.budgetech.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Color")
public class Color {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_color")
	private Long id;

	@Column(name = "name_color", length = 45, nullable = false)
	private String name;

	@Column(name = "brand_color", length = 45, nullable = false)
	private String brand;

	@OneToOne(mappedBy = "color")
	private Furniture furniture;
}
