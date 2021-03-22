package com.latam.millas.Service;

import com.latam.millas.Model.Vuelo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.latam.millas.Exceptions.VueloAlreadyExistException;
import com.latam.millas.Exceptions.VueloEmptyListException;
import com.latam.millas.Exceptions.VueloNotFoundException;
import com.latam.millas.Repository.VueloRepository;

@Service
public class VueloService {

	private final VueloRepository vueloRepository;

	public VueloService(VueloRepository vueloRepository) {
		this.vueloRepository = vueloRepository;
	}
	
	public VueloService(){

		vueloRepository = null;
	}

	public List<Vuelo> getAllVuelos() throws VueloEmptyListException{
		if	(vueloRepository.findAll().isEmpty()) {
			throw new VueloEmptyListException("No hay vuelos en la base de datos");
		}
		return vueloRepository.findAll();
	}
	
	public void agregarVuelo(Vuelo vuelo) throws VueloAlreadyExistException{
		if	(vuelo == null) {
			vueloRepository.save(vuelo);
		}else {
			if	(vueloRepository.getOne(vuelo.getCdg_vuelo())==null) {
				vueloRepository.save(vuelo);
			}else {
				throw new VueloAlreadyExistException("El vuelo " +vuelo.toString()+ " ya se encuentra en la base de datos");
			}
		}
	}
	
	public Vuelo buscarVuelo(int codigo) throws VueloNotFoundException{
		Vuelo vueloEncontrado= vueloRepository.getOne(codigo);
		if	(vueloEncontrado==null) {
			throw new VueloNotFoundException("El vuelo de codigo "+codigo+" no existe en la base de datos.");
		}
		return vueloEncontrado;
	}
	
	
}
