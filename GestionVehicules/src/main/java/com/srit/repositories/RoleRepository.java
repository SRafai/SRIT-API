package com.srit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.srit.entities.Role;
@RepositoryRestResource
public interface RoleRepository extends JpaRepository<Role, Long>{

}
