package com.wellness360.nutrition.preference;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "restrictions")
public interface PreferenceRepository extends JpaRepository<PreferenceEntity, Integer> {
}
