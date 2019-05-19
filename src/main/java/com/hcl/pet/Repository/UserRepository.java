package com.hcl.pet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.pet.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	@Query(value="SELECT * FROM USER  WHERE user_name=? AND password=?",nativeQuery=true)
	public User Login(String userName,String password);

}
