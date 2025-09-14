package com.gl.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.jpa.model.Gender;
import com.gl.jpa.model.Passport;
import com.gl.jpa.model.Person;
import com.gl.jpa.repo.PassportRepo;
@Service
public class PassportService {
	@Autowired
	PassportRepo passportRepo;
	@Autowired
	PersonService personService;
	
	
	public Passport add(String passportNumber, int person_Id) {
		Person person = null;
		try {
		 person = personService.getById(person_Id);
		if(person == null) {
		return null;
		
	     }
		}catch(Exception e) {
			return null;
		}
		
		Passport passport = new Passport (passportNumber,person);
		   return passportRepo.save(passport);	
	}
	//update
	public Passport update(int passportId,String passportNumber,int personId) {
		//verification of passport id
		Passport passport = null;
		Optional<Passport> passportOpt =passportRepo.findById(passportId);
			try {
				if(passportOpt.isEmpty()) {
					return null;
				}
				passport = passportOpt.get();
			}
			catch(Exception ex) {
				return null;
			}
			Person person = null;
			try {
				person = personService.getById(personId);
				if(person == null) {
					return null;
				}
			}catch(Exception ex) {
				return null;
			}
			passport.setPassportNumber(passportNumber);
			passport.setPerson(person);
			
			passportRepo.save(passport);
			return passport;
		}
	//get all passports
	public List<Passport> getAll(){
		return passportRepo.findAll();
	}
	//getpassport using id 
	public Passport getById(int id) {
		Optional<Passport> passport = passportRepo.findById(id);
		if(passport.isEmpty()) {
			return null;
		}
		return passport.get();
	}
	
	public boolean delete(int id) {
		//verification off passportid
		Passport passport = null;
		Optional<Passport> passportOpt = passportRepo.findById(id);
		try {
			if(passportOpt.isEmpty()) {
				return false;
			}
			passport = passportOpt.get();
		}catch(Exception ex) {
			return false;
		}
		passportRepo.delete(passport);
		return true;
	}
	

}














