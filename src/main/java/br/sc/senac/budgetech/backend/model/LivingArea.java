package br.sc.senac.budgetech.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
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

	@ManyToOne
	@JoinColumn(name = "id_woodwork")
	private Woodwork woodwork;

	@OneToMany(mappedBy = "livingArea")
	private List<Furniture> furnitures;

	public LivingArea(Long id, String name) {
		this.id = id;
		this.name = name;
		furnitures = new ArrayList<>();
	}

	public void addFurniture(Furniture furniture) {
		this.furnitures.add(furniture);
	}

	public void removeFurniture(Furniture furniture) {
		this.furnitures.remove(furniture);
	}

	public List<Furniture> getFurniture() {
		return furnitures;
	}
}
