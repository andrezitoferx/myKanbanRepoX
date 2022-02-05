package com.andrez.myKanban.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.andrez.myKanban.models.TareaModel;

@Repository
public interface TareaRepository extends CrudRepository<TareaModel, Long> {
	public abstract ArrayList<TareaModel> findTareasByPriority(Integer priority);
	public abstract ArrayList<TareaModel> findTareasByOwnerId(Long id);
}