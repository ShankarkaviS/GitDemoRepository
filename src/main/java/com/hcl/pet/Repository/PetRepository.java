package com.hcl.pet.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.pet.Model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet,Long> {
    @Modifying
	@Query(value="UPDATE Pet SET user_id=?,status=? WHERE pet_id=?",nativeQuery=true)
	public int buyPet(long userId,boolean status,long pet_id);
}
