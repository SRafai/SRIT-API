package com.srit.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.srit.entities.BL;
@RepositoryRestResource
public interface BLRepository extends JpaRepository<BL, Long>{
	
	@Query("select b from BL b where b.planning.id like :x")
	public BL findBLByPlanning(@Param("x")Long idPl);
	
	@Query("select b from BL b where b.vehicule.immatriculation like :x")
	public List<BL> findBLsByImm(@Param("x")String imm);
	
	@Query("select b from BL b where b.date between :x and :y")
	public List<BL> findBLsByDate(@Param("x")Date dateStart, @Param("y") Date dateEnd);
	

}
