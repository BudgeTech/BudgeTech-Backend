package br.sc.senac.budgetech.backend.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import antlr.collections.List;
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

	@ManyToOne()
	@JoinColumn(name = "id_woodwork")
	private Woodwork woodwork;

	@ManyToOne()
	@JoinColumn(name = "id_client")
	private Client client;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "request_furniture", joinColumns = @JoinColumn(name = "id_request"), inverseJoinColumns = @JoinColumn(name = "id_furniture"))
	private List furnitures;
		
}

