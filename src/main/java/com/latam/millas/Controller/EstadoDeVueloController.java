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

import com.latam.millas.Exceptions.EstadoDeVueloAlreadyExistException;
import com.latam.millas.Exceptions.EstadoDeVueloEmptyListException;
import com.latam.millas.Model.EstadoDeVuelo;
import com.latam.millas.Service.EstadoDeVueloService;

@RestController
@RequestMapping("/Full-millas-sanchez-1/estadoDeVuelo")
public class EstadoDeVueloController {

	private EstadoDeVueloService estadoDeVueloService;

	public EstadoDeVueloController(EstadoDeVueloService estadoDeVueloService) {
		this.estadoDeVueloService = estadoDeVueloService;
	}

	@GetMapping("/")
	public ResponseEntity<List<EstadoDeVuelo>> getAllEstadosDeVuelo() throws EstadoDeVueloEmptyListException{
		List<EstadoDeVuelo> estadoDeVuelos = estadoDeVueloService.getAllEstadosDeVuelo();
		return new ResponseEntity<>(estadoDeVuelos,HttpStatus.OK);
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<EstadoDeVuelo> agregarEstadoDeVuelo(@RequestBody EstadoDeVuelo estadoDeVuelo) throws Exception{
		estadoDeVueloService.agregarEstadoDeVuelo(estadoDeVuelo);
		return new ResponseEntity<>(estadoDeVuelo,HttpStatus.CREATED);
	}
}
