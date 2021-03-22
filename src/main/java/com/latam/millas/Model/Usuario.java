package com.latam.millas.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Entity
@Data
@Component
//@NoArgsConstructor
//@AllArgsConstructor
public class Usuario {

	@Id
	private int cdg_usuario;
	private String email_usuario;
	private String nom_usuario;
	private String app_usuario;
	
	
	public Usuario(int cdg_usuario, String email_usuario, String nom_usuario, String app_usuario) {
		super();
		this.cdg_usuario = cdg_usuario;
		this.email_usuario = email_usuario;
		this.nom_usuario = nom_usuario;
		this.app_usuario = app_usuario;
	}
	
	public Usuario(){
	}
	
	
}
