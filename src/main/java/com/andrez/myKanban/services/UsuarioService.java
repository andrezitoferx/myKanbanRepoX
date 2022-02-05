package com.andrez.myKanban.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrez.myKanban.models.UsuarioModel;
import com.andrez.myKanban.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	public ArrayList<UsuarioModel> getUsuarios(){
		return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
	}
	
	public UsuarioModel saveUsuario(UsuarioModel usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Optional<UsuarioModel> getById(Long id) {
		return usuarioRepository.findById(id);
	}
	
	public ArrayList<UsuarioModel> getByCapacity(Integer capacity){
		return usuarioRepository.findByCapacity(capacity);
	}
	
	public boolean deleteUsuario(Long id) {
		try {
			usuarioRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}