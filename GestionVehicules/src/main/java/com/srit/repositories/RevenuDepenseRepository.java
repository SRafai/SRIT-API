package com.srit.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.srit.entities.RevenuDepense;
@RepositoryRestResource
public interface RevenuDepenseRepository extends JpaRepository<RevenuDepense, Long>{
	@Query("select r from RevenuDepense r where type like 'revenu'")
	public List<RevenuDepense> findAllRevenus(Sort sort);
	@Query("select r from RevenuDepense r where type like 'depense'")
	public List<RevenuDepense> findAllDepenses(Sort sort);

}
