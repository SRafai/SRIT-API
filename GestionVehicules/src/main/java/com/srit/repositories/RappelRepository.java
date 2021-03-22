package com.srit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.srit.entities.Rappel;
@RepositoryRestResource
public interface RappelRepository extends JpaRepository<Rappel, Long>{
	
	@Query("select r from Rappel r where r.receiver.id like :x")
	public List<Rappel> findRappelForReceiver(@Param("x")Long idReceiver);
	@Query("update Rappel r set r.isSeen = true where r.id = :x")
	public Rappel rappelSeen(@Param("x")Long idRappel);

}
