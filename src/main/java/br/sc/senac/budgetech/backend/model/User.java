package br.sc.senac.budgetech.backend.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User")
public abstract class User {
	
	@Column(name = "login_user", length = 45, nullable = false, unique = true)
	private String login;

	@Column(name = "password_user", length = 45, nullable = false)
	private String password;

	@Column(name = "image_user")
	private Blob image;

}
