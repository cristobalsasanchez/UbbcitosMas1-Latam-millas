package com.latam.millas.Controller.tdd;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.latam.millas.Controller.UsuarioController;
import com.latam.millas.Exceptions.UsuariosEmptyListException;
import com.latam.millas.Model.Usuario;
import com.latam.millas.Service.UsuarioService;
import org.junit.assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;


import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@ExtendWith(MockitoExtension.class)
public class UsuarioControllerTest {
	
	private MockMvc mockMvc;

	@Mock
	private UsuarioService usuarioService;
	
	private JacksonTester<List<Usuario>> jsonListaUsuario;
	private JacksonTester<Usuario> jsonUsuario;
	
	@InjectMocks
	private UsuarioController usuarioController;
	
	@BeforeEach
	void setup() {
		JacksonTester.initFields(this, new ObjectMapper());
		mockMvc = MockMvcBuilders.standaloneSetup(usuarioController).build();
	}
	
	@Test
	void SiSeInvocaGetAllUsuariosDebeRetornarTodosLosUsuarios() throws Exception{
		//Given
		ArrayList<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario(1,"cristobalsanchez@gmail.com","cristobal","sanchez"));
		usuarios.add(new Usuario(2,"juanfonseca@gmail.com","juan","fonseca"));
		
		given(usuarioService.getAllUsuarios()).willReturn(usuarios);
		
		//When
		MockHttpServletResponse response = mockMvc.perform(get("/Full-millas-sanchez-1/usuarios/")
											.accept(MediaType.APPLICATION_JSON))
											.andReturn()
											.getResponse();
		
		//Then
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.getContentAsString()).isEqualTo(jsonListaUsuario.write(usuarios).getJson());
		//AssertTrue
	}
	
	@Test
	void siSeInvocaGetAllUsuariosYLaListaEstaVaciaDebeRetonrarExceptionEmptyList() throws Exception{
		//Given
		doThrow(new UsuariosEmptyListException()).when(usuarioService).getAllUsuarios();
		
		//When
		MockHttpServletResponse response = mockMvc.perform(get("/Full-millas-sanchez-1/usuarios/")
										   .accept(MediaType.APPLICATION_JSON))
											.andReturn()
											.getResponse();
		
		//Then
		AssertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
	}
	
}
