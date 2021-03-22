package com.srit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.srit.entities.Commande;
@RepositoryRestResource
public interface CommandeRepository extends JpaRepository<Commande, Long>{
	
	@Query("select c from Commande c where c.bc.id like :x")
	public List<Commande> findCommandesByBC(@Param("x")Long idBC);

}
