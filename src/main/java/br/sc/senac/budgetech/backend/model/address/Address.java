package br.sc.senac.budgetech.backend.model.address;

import br.sc.senac.budgetech.backend.model.client.Client;
import br.sc.senac.budgetech.backend.model.user.User;
import br.sc.senac.budgetech.backend.model.woodwork.Woodwork;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;

    @Column(name = "address_street", length = 45, nullable = false)
    private String street;

    @Column(name = "address_number", nullable = false)
    private int number;

    @Column(name = "address_complement", length = 45, nullable = false)
    private String complement;

    @Column(name = "address_neighborhood", length = 45, nullable = false)
    private String neighborhood;

    @Column(name = "address_city", length = 45, nullable = false)
    private String city;

    @Column(name = "address_province", length = 45, nullable = false)
    private String province;

    @Column(name = "address_cep", nullable = false)
    private String cep;

    @OneToOne(mappedBy = "address")
    private User user;

//    @OneToOne(mappedBy = "address")
//    private Client client;
//
//    @OneToOne(mappedBy = "address")
//    private Woodwork woodwork;

    public Address(Long id, String street, int number, String complement, String neighborhood, String city, String province, String cep) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.city = city;
        this.province = province;
        this.cep = cep;
    }
}
