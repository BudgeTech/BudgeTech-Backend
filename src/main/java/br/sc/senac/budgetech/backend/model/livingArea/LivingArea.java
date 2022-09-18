package br.sc.senac.budgetech.backend.model.livingArea;

import br.sc.senac.budgetech.backend.model.furniture.Furniture;
import br.sc.senac.budgetech.backend.model.item.Item;
import br.sc.senac.budgetech.backend.model.woodwork.Woodwork;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Blob;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "living_area")
public class LivingArea {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "living_area_id")
	private Long id;

	@Column(name = "living_area_image")
	private Blob image;

	@Column(name = "living_area_name", length = 45, nullable = false)
	private String nameLivingArea;

	@ManyToOne
	@JoinColumn(name = "woodwork_id")
	private Woodwork woodwork;

	@OneToMany(mappedBy = "livingArea", cascade = CascadeType.ALL)
	private List<Furniture> furnitures;

	public LivingArea(Long id, String nameLivingArea, Blob image) {
		this.id = id;
		this.nameLivingArea = nameLivingArea;
		this.image = image;
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
