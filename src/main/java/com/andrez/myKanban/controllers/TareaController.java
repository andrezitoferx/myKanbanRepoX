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

import com.andrez.myKanban.models.TareaModel;
import com.andrez.myKanban.services.TareaService;

@RestController
@RequestMapping("/tarea")
public class TareaController {

	@Autowired
	TareaService tareaService;

	@PostMapping()
	public TareaModel saveTarea(@RequestBody TareaModel tarea) {
		return this.tareaService.saveTarea(tarea);
	}
	
	@GetMapping()
	public ArrayList<TareaModel> getTareas() {
		return tareaService.getTareas();
	}
	
	@GetMapping(path = "/tareasUsuario/{id}")
	public ArrayList<TareaModel> getTareasByUsuario(@PathVariable("id") Long id) {
		return tareaService.getTareasByUsuario(id);
	}

	@GetMapping(path = "/{id}")
	public Optional<TareaModel> getTareaById(@PathVariable("id") Long id) {
		return this.tareaService.getById(id);
	}

	@GetMapping(path = "/search")
	public ArrayList<TareaModel> getTareaByPriority(@RequestParam("priority") Integer priority) {
		return this.tareaService.getByPriority(priority);
	}

	@DeleteMapping(path = "/{id}")
	public String deleteById(@PathVariable("id") Long id) { 
		boolean deleted = this.tareaService.deleteTarea(id);
		return deleted ? "Se eliminó la tarea " + id : "No existe una tarea con el ID " + id;
	}
}
