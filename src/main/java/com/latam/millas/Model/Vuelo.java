package com.latam.millas.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import org.springframework.stereotype.Component;

@Entity
@Data
@Component
public class Vuelo {

	@Id
	private int cdg_vuelo;
	private String pnr;
	private String departure;
	private String arrival;
	private Date departure_date;
	private Date arrival_date;
	private String flight_number;
	
	public Vuelo(int cdg_vuelo, String pnr, String departure, String arrival, Date departure_date, Date arrival_date,
			String flight_number) {
		super();
		this.cdg_vuelo = cdg_vuelo;
		this.pnr = pnr;
		this.departure = departure;
		this.arrival = arrival;
		this.departure_date = departure_date;
		this.arrival_date = arrival_date;
		this.flight_number = flight_number;
	}
	
	public Vuelo() {
		
	}
	
}
