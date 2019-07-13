package com.aprendizaje.springboot.web.app.controllers;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

import com.aprendizaje.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	/*@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index() {
		return "index";
	}*/
	//Así se puede hacer con los POST, DELETE, PUT, etc......
	
	//Si quiero mapear varias rutas
	@GetMapping({"/index", "/", "", "/home"})
	public String index(Model model) {
		model.addAttribute("titulo", textoIndex);
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		//En la practica estos datos vienen de nuestras clases repository, service, etc como consultas
		usuario.setNombre("Miguel");
		usuario.setApellido("Chamorro");
		usuario.setEmail("miguel@correo.com");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		
		model.addAttribute("titulo", textoListar);
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = Arrays.asList(new Usuario("Miguel", "Chamorro", "miguel@correo.com"),
				new Usuario("Rodrigo", "Díaz", "rod@correo.com"),
				new Usuario("Mary", "Jane", "mary@correo.com"),
				new Usuario("Jorge", "Díaz", "jorge@correo.com"));
		
		return usuarios;
	}
	
	
}
