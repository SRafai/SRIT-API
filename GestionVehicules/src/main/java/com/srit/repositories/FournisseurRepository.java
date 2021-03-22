package com.srit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.srit.entities.Fournisseur;
@RepositoryRestResource
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long>{
	
	@Query("select f from Fournisseur f where f.siren like :x")
	public Fournisseur findFournisseurBySiren(@Param("x")int siren);
	
	@Query("select f from Fournisseur f where f.rs like :y")
	public Fournisseur findFournisseurByRS(@Param("y")String rs);
	
	@Query("select f from Fournisseur f where f.type like :z")
	public List<Fournisseur> findFournisseursByType(@Param("z")String type);

}
