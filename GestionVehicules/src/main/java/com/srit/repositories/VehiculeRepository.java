package com.srit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.srit.entities.Vehicule;

//@RepositoryRestResource
public interface VehiculeRepository extends JpaRepository<Vehicule, Long>{
	
	@Query("select v from Vehicule v where v.immatriculation like :x")
	public Vehicule findVehiculeByImmatriculation(@Param("x")String imm);

}
