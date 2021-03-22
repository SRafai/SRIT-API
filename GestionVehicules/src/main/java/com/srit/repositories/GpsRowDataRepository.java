package com.srit.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.srit.entities.GpsRowData;
@RepositoryRestResource
public interface GpsRowDataRepository extends JpaRepository<GpsRowData, Long> {

	@Query("select g from GpsRowData g where g.vehicule.immatriculation like :x and g.date between :y and :z")
	public List<GpsRowData> findGpsRowsDataByImmandDate(@Param("x") String imm, @Param("y") Date dateDebut,
			@Param("z") Date dateFin);

}
