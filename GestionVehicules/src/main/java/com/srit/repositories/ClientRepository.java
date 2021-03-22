package com.srit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.srit.entities.Client;
@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client, Long>{
	@Query("select c from Client c where c.siren like :x")
	public Client findClientBySiren(@Param("x")int siren);
	@Query("select c from Client c where c.rs like :y")
	public Client findClientByRS(@Param("y")String rs);

}
