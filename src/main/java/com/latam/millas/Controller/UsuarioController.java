package com.latam.millas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.latam.millas.Exceptions.UsuarioAlreadyExistsException;
import com.latam.millas.Exceptions.UsuarioNotFoundException;
import com.latam.millas.Exceptions.UsuariosEmptyListException;
import com.latam.millas.Model.InputRequest;
import com.latam.millas.Model.Usuario;
import com.latam.millas.Service.UsuarioService;

@RestController
@RequestMapping("/Full-millas-sanchez-1/usuarios")
public class UsuarioController {

	private final UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@GetMapping("/")
	public ResponseEntity<List<Usuario>> getAllUsuarios() throws UsuariosEmptyListException{
		try {
			List<Usuario> usuarios= usuarioService.getAllUsuarios();
			return new ResponseEntity<>(usuarios,HttpStatus.OK);
		}catch (UsuariosEmptyListException e) {
			System.err.print(e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/add")
	public ResponseEntity<Usuario> agregarUsuario(@RequestBody Usuario usuario) throws UsuarioNotFoundException, UsuarioAlreadyExistsException{
		try {
			usuarioService.agregarUsuario(usuario);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}catch (UsuarioAlreadyExistsException e) {
			System.err.print(e);
			return new ResponseEntity<>(null, HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("/delete/{cdg_usuario}")
	public ResponseEntity<Usuario> delete(@PathVariable int cdg) throws UsuarioNotFoundException{
		try {
			usuarioService.eliminarUsuario(cdg);
			return new ResponseEntity<Usuario>(HttpStatus.OK);
		}catch (UsuarioNotFoundException e) {
			System.err.print(e);
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
	}

	/*
	@GetMapping("/input")
	public String input(@RequestParam("pnr") String pnr, @RequestParam("email_usuario") String email) {
		return "";
	}
	
	@GetMapping(value = "/input")
	public InputRequest getString(@RequestBody InputRequest inputRequest) {
		return inputRequest;
	}

	 */
}
