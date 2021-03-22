package com.latam.millas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.latam.millas.Exceptions.VueloAlreadyExistException;
import com.latam.millas.Exceptions.VueloEmptyListException;
import com.latam.millas.Exceptions.VueloNotFoundException;
import com.latam.millas.Model.Vuelo;
import com.latam.millas.Service.VueloService;

@RestController
@RequestMapping("/Full-millas-sanchez-1/vuelos")
public class VueloController {
	
	private final VueloService vueloService;

	public VueloController(VueloService vueloService) {
		this.vueloService = vueloService;
	}

	@GetMapping("/")
	public ResponseEntity<List<Vuelo>> getAllVuelos() throws VueloEmptyListException{
		try {
			List<Vuelo> vuelos = vueloService.getAllVuelos();
			return new ResponseEntity<>(vuelos,HttpStatus.OK);
		}catch (VueloEmptyListException e) {
			System.err.print(e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<Vuelo> agregarVuelo(@RequestBody Vuelo vuelo) throws VueloNotFoundException{
		try {
			vueloService.agregarVuelo(vuelo);
			return new ResponseEntity<>(vuelo, HttpStatus.CREATED);
		}catch (VueloAlreadyExistException e) {
			System.err.print(e);
			return new ResponseEntity<>(null, HttpStatus.CONFLICT);
		}
	}
	

}
