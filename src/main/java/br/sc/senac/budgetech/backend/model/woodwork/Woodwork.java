package br.sc.senac.budgetech.backend.model.woodwork;

import br.sc.senac.budgetech.backend.model.item.Item;
import br.sc.senac.budgetech.backend.model.livingArea.LivingArea;
import br.sc.senac.budgetech.backend.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "woodwork")
@PrimaryKeyJoinColumn(name="woodwork_id", referencedColumnName="user_id")
public class Woodwork extends User {

	@Column(name = "woodwork_company_name", nullable = false)
	private String companyName;
	
	@Column(name = "woodwork_cnpj", nullable = false, unique = true)
	private String cnpj;

	@Column(name = "woodwork_description")
	private String description;

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private List<Item> items;

	@OneToMany(mappedBy = "woodwork", cascade = CascadeType.ALL)
	private List<LivingArea> livingAreas;

	public Woodwork(Long id, String login, String password, byte[] image, String companyName, String cnpj, String description) {
		super(id, login, password, image);
		this.companyName = companyName;
		this.cnpj = cnpj;
		this.description = description;
	}

	public List<LivingArea> getLivingAreas() {
		return livingAreas;
	}

	public void addLivingArea(LivingArea livingArea) {
		this.livingAreas.add(livingArea);
	}

	public void removeLivingArea(LivingArea livingArea) {
		this.livingAreas.remove(livingArea);
	}

	public List<Item> getItems() {
		return items;
	}

	public void addItem(Item item) {
		this.items.add(item);
	}

	public void removeItem(Item item) {
		this.items.remove(item);
	}
}
