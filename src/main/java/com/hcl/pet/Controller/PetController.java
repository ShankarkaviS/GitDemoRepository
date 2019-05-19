package com.hcl.pet.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.pet.Model.Pet;
import com.hcl.pet.Model.User;
import com.hcl.pet.Service.PetService;

@RestController
public class PetController {

	@Autowired
	PetService petService;
	
	@PostMapping("/addPet")
	public String addPet(@RequestBody Pet pet)
	{
		System.out.println(pet.isStatus());
		petService.addPet(pet);
		return"Pet Added Successfully...";
	}
	
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody User user)
	{
		return petService.addUser(user);
	}
	
	@GetMapping("/login")
	public List<Pet> login(@RequestBody User user)
	{	
	return petService.login(user);	
	}
	
	@GetMapping("/getAll")
	public List<Pet> getAll()
	{	
	return petService.getAll();
	}
	
	@PutMapping("/buyPet/{petId}")
	public String buyPet(@PathVariable long petId,@RequestParam long userId )
	{ 
		System.out.println("The Path Variable  Value is "+petId+" "+userId+"  Hi");
		return petService.buyPet(userId,petId,false);
	}

	
}
