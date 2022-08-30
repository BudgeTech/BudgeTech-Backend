package br.sc.senac.budgetech.backend.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import br.sc.senac.budgetech.backend.enumeration.Payment;
import br.sc.senac.budgetech.backend.enumeration.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "request")
public class Request {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_request")
	private Long id;

	@Column(name = "price_request")
	private double price;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "status_request", nullable = false)
	private Status status;

	@Column(name = "final_date_request", nullable = false)
	private LocalDate finalDate;

	@Column(name = "initial_date_request", nullable = false)
	private LocalDate initialDate;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "payment_request", nullable = false)
	private Payment payment;

	@ManyToOne
	@JoinColumn(name = "id_woodwork")
	private Woodwork woodwork;

	@ManyToOne
	@JoinColumn(name = "id_client")
	private Client client;

	@OneToMany(mappedBy = "request")
	private List<Furniture> furnitures;
		
}

