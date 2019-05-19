package com.hcl.pet.ServiceTest;



import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.hcl.pet.Model.Pet;
import com.hcl.pet.Repository.PetRepository;
import com.hcl.pet.Service.PetService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PetServiceTest {
	
	
	@Autowired
	private PetService petService;
	
	@MockBean
	private PetRepository petRepository;
	
	
	@Test
	public void getAllTest()
	{
		when(petRepository.findAll()).thenReturn(Stream
				.of(new Pet(1,"Cat","Mumbai",true),new Pet(2,"Dog","Bangalore",false)).collect(Collectors.toList()));
		assertEquals(2, petService.getAll().size());	
	}

	
	
	

}
