package com.hcl.pet.Service;



import java.util.List;

import com.hcl.pet.Model.Pet;

import com.hcl.pet.Model.User;


public interface PetService {
	public String addPet(Pet pet);
	public String addUser(User user);
	public List<Pet> login(User user);
	public List<Pet> getAll();
	public Pet getPet(Long petId);
	public String buyPet(long userId,long petId,boolean status);
	
}
