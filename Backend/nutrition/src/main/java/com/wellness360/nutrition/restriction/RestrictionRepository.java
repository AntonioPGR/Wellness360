package com.wellness360.nutrition.restriction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "restrictions")
public interface RestrictionRepository extends JpaRepository<RestrictionEntity, Integer> {
}
