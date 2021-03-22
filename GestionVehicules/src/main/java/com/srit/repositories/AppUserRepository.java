package com.srit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.srit.entities.AppUser;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "users")
public interface AppUserRepository extends JpaRepository<AppUser, Long>{
	@RestResource(path = "/findByEmail")
	public AppUser findByEmail(@Param("email") String email);
	@RestResource(path="/findByRoleName")
	public AppUser findByRoleName(@Param("role") String role);
	@RestResource(path="/findOtherUsers")
	@Query("select u from AppUser u where u.role not like 'admin'")
	public List<AppUser> findOtherUsers();
	@RestResource(path = "/login")
	public AppUser findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
