package com.gl.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.jpa.model.Animal;
import com.gl.jpa.service.AnimalService;

@RestController
public class AnimalController {
	@Autowired
	AnimalService animalService;
	@PostMapping("/animal/add")
	public ResponseEntity add(@RequestParam String name,@RequestParam int age) {
		Animal animal = new Animal(name,age);
		   animalService.add(animal); 
		return ResponseEntity.status(HttpStatus.OK).body(animal);
		
	}
	@GetMapping("/animal/getall")
	public ResponseEntity getAll() {
		List<Animal> animals = animalService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(animals);
		
	}
	@GetMapping("/animal/getbyid")
	public ResponseEntity getById(@RequestParam int id) {
		Animal animal =animalService.getById(id);
		if(animal != null) {
			return ResponseEntity.status(HttpStatus.OK).body(animal);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Animal not found");
	}
	@PutMapping("/animal/update")
	public ResponseEntity update(@RequestParam int id, @RequestParam String name,@RequestParam int age) {
		Animal animal = new Animal(name,age);
		animal.setId(id);
		animalService.update(animal);
		return ResponseEntity.status(HttpStatus.OK).body("Animal updated successfully");
	}
	@DeleteMapping("/animal/delete")
	public ResponseEntity delete(@RequestParam int id) {
		animalService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("Animal deleted successfully");
	}

}
