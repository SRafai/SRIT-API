package com.srit.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.srit.entities.Planning;

public interface PlanningRepository extends JpaRepository<Planning, Long> {

	@Query("select p from Planning p where p.vehicule.immatriculation like :x")
	public List<Planning> findPlanningsByImm(@Param("x") String imm, Sort sort);
	@Query("select p from Planning p where p.vehicule.immatriculation like :x and p.date between :y and :z")
	public List<Planning> findPlanningsByImmandDate(@Param("x") String imm, @Param("y") Date dateD,
			@Param("z") Date dateF, Sort sort);

}
