package com.latam.millas.Service.tdd;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import com.latam.millas.Exceptions.UsuarioAlreadyExistsException;
import com.latam.millas.Exceptions.UsuarioNotFoundException;
import com.latam.millas.Exceptions.UsuariosEmptyListException;
import com.latam.millas.Model.Usuario;
import com.latam.millas.Repository.UsuarioRepository;
import com.latam.millas.Service.UsuarioService;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {
	
	@Mock
	private UsuarioRepository usuarioRepository;

	@InjectMocks
	private UsuarioService usuarioService;
	
	@Test 
	void SiSeInvoceGetAllUsuariosDebeRetornarTodosLosUsuarios() throws UsuariosEmptyListException{
		//Arrange
		ArrayList<Usuario> usuarios=new ArrayList<>();
		List<Usuario> resultado;
		usuarios.add(new Usuario(1,"cristobalsanchez@gmail.com","cristobal","sanchez"));
		usuarios.add(new Usuario(2,"juanfonseca@gmail.com","juan","fonseca"));
		when(usuarioRepository.findAll()).thenReturn(usuarios);
		
		//Act
		resultado= usuarioService.getAllUsuarios();
		
		//Assert
		assertNotNull(resultado);
		assertAll("resultado",
				()-> assertEquals(1,resultado.get(0).getCdg_usuario()),
				()-> assertEquals("cristobalsanchez@gmail.com",resultado.get(0).getEmail_usuario()),
				()-> assertEquals("cristobal",resultado.get(0).getNom_usuario()),
				()-> assertEquals("sanchez",resultado.get(0).getApp_usuario()),
				()-> assertEquals(2,resultado.get(1).getCdg_usuario()),
				()-> assertEquals("juanfonseca@gmail.com",resultado.get(1).getEmail_usuario()),
				()-> assertEquals("juan",resultado.get(1).getNom_usuario()),
				()-> assertEquals("fonseca",resultado.get(1).getApp_usuario())
				);
		}
	
	@Test
	void siSeInvocaGetAllUsuariosYNoExisteNingunUsuarioRetornaLaExceptionUsuariosEmptyList() {
		assertThrows(UsuariosEmptyListException.class,()-> usuarioService.getAllUsuarios());
	}
	
	@Test
	void SiSeDeseaAgregarUnUsuarioEntoncesLoPuedeAgregar() throws UsuarioAlreadyExistsException, UsuarioNotFoundException{
		//Arrange 
		List<Usuario> usuarios = new ArrayList<>();
		Usuario usuario = new Usuario (1,"claudioquinteros@gmail.com","claudio","quitneros");
		Usuario usuarioExistente = new Usuario(2,"diegolopez@gmail.com","diego","lopez");
		usuarios.add(usuarioExistente);
		when(usuarioRepository.findAll()).thenReturn(usuarios);
		
		usuarioService.agregarUsuario(usuario);
		verify(usuarioRepository,times(1)).save(usuario);
	}
}
