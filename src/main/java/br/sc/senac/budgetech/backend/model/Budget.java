package br.sc.senac.budgetech.backend.model;

import java.time.LocalDate;
import java.util.ArrayList;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;

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
@Table(name = "Budget")
public class Budget {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_budget")
	private Long id;

	@Column(name = "price_budget", nullable = false)
	private Double price;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "status_budget", nullable = false)
	private Status status;

	@Column(name = "final_date_budget", nullable = false)
	private LocalDate finalDate;

	@Column(name = "initial_date_budget", nullable = false)
	private LocalDate initialDate;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "payment_budget", nullable = false)
	private Payment payment;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Request request;

	@ManyToOne()
	@JoinColumn(name = "id_woodwork")
	private Woodwork woodwork;

	@ManyToOne()
	@JoinColumn(name = "id_client")
	private Client client;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "budget_furniture", joinColumns = @JoinColumn(name = "id_budget"), inverseJoinColumns = @JoinColumn(name = "id_furniture"))
	private List<Furniture> furnitures = new ArrayList<>();
}
