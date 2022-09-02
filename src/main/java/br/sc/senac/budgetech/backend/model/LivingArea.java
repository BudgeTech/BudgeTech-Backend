package br.sc.senac.budgetech.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "living_area")
public class LivingArea {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_living_area")
	private Long id;

	@Column(name = "name_living_area", length = 45, nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "livingArea")
	private List<Furniture> furnitures;

	@ManyToOne
	@JoinColumn(name = "id_woodwork")
	private Woodwork woodwork;
}
