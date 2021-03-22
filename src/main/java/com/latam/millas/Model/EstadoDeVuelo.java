package com.latam.millas.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import org.springframework.stereotype.Component;

@Entity
@Data
@Component
public class EstadoDeVuelo {
	
	private boolean cdg_status;
	@Id
	private int cdg_vuelo;
	private String flight_number;
	private boolean flight_status;
	
	public EstadoDeVuelo(boolean cdg_status, int cdg_vuelo, String flight_number, boolean flight_status) {
		super();
		this.cdg_status = cdg_status;
		this.cdg_vuelo = cdg_vuelo;
		this.flight_number = flight_number;
		this.flight_status = flight_status;
	}
	
	public EstadoDeVuelo() {
		
	}



}
