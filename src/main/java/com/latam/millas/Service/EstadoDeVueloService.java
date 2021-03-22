package com.latam.millas.Service;

import java.util.List;

import com.latam.millas.Exceptions.EstadoDeVueloEmptyListException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.latam.millas.Exceptions.EstadoDeVueloNotFoundException;
import com.latam.millas.Exceptions.VueloNotFoundException;
import com.latam.millas.Model.EstadoDeVuelo;
import com.latam.millas.Repository.EstadoDeVueloRepository;
import com.latam.millas.Repository.VueloRepository;

@Service
public class EstadoDeVueloService {

	
	///REvisaaaar
	
	
	private EstadoDeVueloRepository estadoDeVueloRepository;
	private VueloRepository vueloRepository;

	public EstadoDeVueloService(EstadoDeVueloRepository estadoDeVueloRepository) {
		this.estadoDeVueloRepository = estadoDeVueloRepository;
	}

	public EstadoDeVueloService(){
		estadoDeVueloRepository = null;
	}

	public void agregarEstadoDeVuelo(EstadoDeVuelo estadoDeVuelo) throws VueloNotFoundException{
		if	(vueloRepository.getOne(estadoDeVuelo.getCdg_vuelo()) != null) {
			estadoDeVueloRepository.save(estadoDeVuelo);
		}else {
			throw new VueloNotFoundException("El estado de vuelo no ha encontrado el vuelo");
		}
	}

	public List<EstadoDeVuelo> getAllEstadosDeVuelo() throws EstadoDeVueloEmptyListException {
		if	(estadoDeVueloRepository.findAll().isEmpty()){
			throw new EstadoDeVueloEmptyListException("No se han encntrado Estados de Vuelos activos");
		}
		return estadoDeVueloRepository.findAll();
	}
	
	
}
