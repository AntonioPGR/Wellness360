package com.wellness360.exercises.app.exercises.equipments;

import org.springframework.stereotype.Repository;

import com.wellness360.exercises.packages.crud.repositories.CrudRepository;

@Repository
public interface EquipmentRepository extends CrudRepository<EquipmentEntity> {
}
