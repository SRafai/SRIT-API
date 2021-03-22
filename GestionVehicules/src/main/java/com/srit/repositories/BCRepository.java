package com.srit.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.srit.entities.BC;
@RepositoryRestResource
public interface BCRepository extends JpaRepository<BC, Long>{
	@Query("select b from BC b where b.vehicule.immatriculation like :x")
	public List<BC> findBCsByImm(@Param("x")String imm);
	@Query("select b from BC b where b.date between :x and :y")
	public List<BC> findBCsByDate(@Param("x")Date dateStart, @Param("y")Date dateEnd);
	@Query("select b from BC b where b.isValid = false")
	public List<BC> findAllBCNotValidated(Sort sort);

}
