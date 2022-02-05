package com.andrez.myKanban.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.andrez.myKanban.models.UsuarioModel;
import com.andrez.myKanban.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@PostMapping()
	public UsuarioModel saveUsuario(@RequestBody UsuarioModel usuario) {
		return this.usuarioService.saveUsuario(usuario);
	}
	
	@GetMapping()
	public ArrayList<UsuarioModel> getUsuarios() {
		return usuarioService.getUsuarios();
	}

	@GetMapping(path = "/{id}")
	public Optional<UsuarioModel> getUsuarioById(@PathVariable("id") Long id) {
		return this.usuarioService.getById(id);
	}

	@GetMapping(path = "/search")
	public ArrayList<UsuarioModel> getUsuarioByCapacity(@RequestParam("capacity") Integer capacity) {
		return this.usuarioService.getByCapacity(capacity);
	}

	@DeleteMapping(path = "/{id}")
	public String deleteById(@PathVariable("id") Long id) {
		boolean deleted = this.usuarioService.deleteUsuario(id);
		return deleted ? "Se eliminó el usuario " + id : "No existe un usuario con el ID " + id;
	}
}
