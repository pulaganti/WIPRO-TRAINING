package com.gl.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.jpa.model.Gender;
import com.gl.jpa.model.Person;
import com.gl.jpa.repo.PersonRepo;

@Service
public class PersonService {
	@Autowired
	PersonRepo  personRepo;
	@Autowired
	GenderService genderService;
	
	
	public Person add(String name, int genderId) {
		Gender gender = null;
		try {
		 gender = genderService.getById(genderId);
		if(gender == null) {
		System.err.println("Gender is Inavlid");
		return null;
		
	     }
		}catch(Exception e) {
			return null;
		}
		
		Person person = new Person (name,gender);
		    personRepo.save(person);
		    return person;
	}
	public List<Person> getAll(){
		return personRepo.findAll();
	}
	
	public Person getById(int id) {
		try {
			Optional<Person> personOpt = personRepo.findById(id);
			if(personOpt.get() != null) {
				return personOpt.get();
			}
			return null;
		}catch(Exception ex) {
			return null;
		}
		
	}
	


}
