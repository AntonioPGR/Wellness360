package com.wellness360.nutrition.restriction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestrictionRepository extends JpaRepository<RestrictionEntity, Integer> {
}
