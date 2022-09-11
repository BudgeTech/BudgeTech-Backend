package br.sc.senac.budgetech.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Blob;

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

	public LivingArea(Long id, String nameLivingArea, Blob image) {
		this.id = id;
		this.nameLivingArea = nameLivingArea;
		this.image = image;
	}
}
