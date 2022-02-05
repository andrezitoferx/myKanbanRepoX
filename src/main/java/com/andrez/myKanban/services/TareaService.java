package com.andrez.myKanban.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrez.myKanban.models.TareaModel;
import com.andrez.myKanban.repositories.TareaRepository;

@Service
public class TareaService {

	@Autowired
	TareaRepository tareaRepository;
	
	public ArrayList<TareaModel> getTareas(){
		return (ArrayList<TareaModel>) tareaRepository.findAll();
	}
	
	//String json = new Gson().toJson(mylist);
	public ArrayList<TareaModel> getTareasByUsuario(Long id){
		return (ArrayList<TareaModel>) tareaRepository.findTareasByOwnerId(id);
	}
	
	public TareaModel saveTarea(TareaModel tarea) {
		return tareaRepository.save(tarea);
	}
	
	public Optional<TareaModel> getById(Long id) {
		return tareaRepository.findById(id);
	}
	
	public ArrayList<TareaModel> getByPriority(Integer priority){
		return tareaRepository.findTareasByPriority(priority);
	}
	
	public boolean deleteTarea(Long id) {
		try {
			tareaRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}