package br.sc.senac.budgetech.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "image")
public class Image {
	
	@Id
	@Column(name = "id_image")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name_image")
	private String name;
	
	@Column(name = "type_image")
	private String type;
	
	@Column(name = "picByte_image", length = 1000)
	private byte[] picByte;

}
