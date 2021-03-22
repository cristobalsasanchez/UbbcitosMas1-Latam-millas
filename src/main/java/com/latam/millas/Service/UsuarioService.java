package com.latam.millas.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.latam.millas.Exceptions.UsuarioAlreadyExistsException;
import com.latam.millas.Exceptions.UsuarioNotFoundException;
import com.latam.millas.Exceptions.UsuariosEmptyListException;
import com.latam.millas.Model.Usuario;
import com.latam.millas.Repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public UsuarioService(){

		usuarioRepository = null;
	}

	public List<Usuario> getAllUsuarios() throws UsuariosEmptyListException{
		if	(usuarioRepository.findAll().isEmpty()) {
			throw new UsuariosEmptyListException("No se han encontrado usuarios ");
		}
		return usuarioRepository.findAll();
	}
	
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Usuario getByCodigo(int codigo) throws UsuarioNotFoundException{
		if	(usuarioRepository.getOne(codigo)==null) {
			throw new UsuarioNotFoundException("No se han encontrado usuarios con el codigo" + codigo);
		}else {
			return usuarioRepository.getOne(codigo);
		}
	}
	
	public Usuario getUsuarioByEmail (String email) throws UsuarioNotFoundException{
		Usuario usuario = null;
		List<Usuario> usuarios= usuarioRepository.findAll();
		if	(!usuarios.isEmpty()) {
			//for each -> javastream
			for	(int i=0; i<usuarios.size();i++) {
				if	(usuarios.get(i).getEmail_usuario().equalsIgnoreCase(email)) {
					return usuarios.get(i);
				}
			}
		}
		return usuario;
	}
	
	public void agregarUsuario(Usuario usuario) throws UsuarioAlreadyExistsException, UsuarioNotFoundException{
		if	(getUsuarioByEmail(usuario.getEmail_usuario())==null) {
			usuarioRepository.save(usuario);
		}else {
			throw new UsuarioAlreadyExistsException("El usuario ya existe en la base de datos.");
		}
	}
	
	public void eliminarUsuario(int codigo) throws UsuarioNotFoundException{
		Usuario usuario = getByCodigo(codigo);
		if	(usuario==null) {
			throw new UsuarioNotFoundException("No se han encontrado usuarios con el codigo " +codigo+ " en la base de datos.");
		}
		usuarioRepository.delete(usuario);
	}
	
}
