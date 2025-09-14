package com.gl.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.jpa.model.Animal;
import com.gl.jpa.repo.AnimalRepo;


@Service
public class AnimalService {
	@Autowired
	AnimalRepo repo;
	
	public void add(Animal animal) {
		repo.save(animal);
	}
	public List<Animal> getAll(){
		return repo.findAll();
	}
	
	public Animal getById(int id) {
		Optional<Animal> animalOpt = repo.findById(id);
		if(animalOpt.get() != null) {
			return animalOpt.get();
			
		}
		return null;
	}
	
	public void delete(int id) {
		Animal animal = new Animal();
		animal.setId(id);
		repo.delete(animal);
	}
	public void update(Animal animal) {
		repo.save(animal);
		
		
	}

}
