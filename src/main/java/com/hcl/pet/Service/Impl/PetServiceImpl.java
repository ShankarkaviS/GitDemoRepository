package com.hcl.pet.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.hcl.pet.Model.Pet;

import com.hcl.pet.Model.User;
import com.hcl.pet.Repository.PetRepository;
import com.hcl.pet.Repository.UserRepository;
import com.hcl.pet.Service.PetService;

@Service
public class PetServiceImpl implements PetService {

	@Autowired
	PetRepository petRepository; 
	
	@Autowired
	UserRepository userRepository;
	
	
	
	@Override
	public String addPet(Pet pet) {
		  petRepository.save(pet);
		return"Pet Created Successfully";
	}

	@Override
	public String addUser(User user) {
		
		if(user.getPassword().equals(user.getConformPassword()))
		{
			userRepository.save(user);
			return"Add User Successfully";
		}else
		{
			return"Please Check Conform Password";
		}	
	}

	@Override
	public List<Pet> login(User user) {
		user=userRepository.Login(user.getUserName(), user.getPassword());
		if(user.getUserName()!=null)
		 return petRepository.findAll();
	      else
	    	  return null;	
	}

	@Override
	public List<Pet> getAll() {
		
   List<Pet> petList=petRepository.findAll();
		return petList;
	}

	@Override
	public Pet getPet(Long petId) {
		return petRepository.getOne(petId);
	}

	@Override
	public String buyPet(long userId,long petId,boolean status) {
		System.out.println("Hi This is ServiceImpl Layer"+ userId+" "+ status+" "+petId);
		int number=petRepository.buyPet(userId, status, petId);
		if(number!=0)
		{
			return"Record Updated Successfully...";
		}else
		{
			return "Invalid Data Please Check";
		}
		
	}

	
}
