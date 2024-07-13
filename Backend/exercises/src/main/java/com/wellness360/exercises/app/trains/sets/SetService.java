package com.wellness360.exercises.app.trains.sets;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellness360.exercises.app.exercises.ExerciseEntity;
import com.wellness360.exercises.app.trains.TrainEntity;
import com.wellness360.exercises.app.trains.dtos.ExercisesSetsCreateDTO;
import com.wellness360.exercises.app.trains.dtos.ExercisesSetsReturnDTO;
import com.wellness360.exercises.app.trains.sets.dtos.SetCreatePersistenceDTO;
import com.wellness360.exercises.app.trains.sets.dtos.SetCreateRequestDTO;
import com.wellness360.exercises.tools.EntityRetriever;

@Service
public class SetService {

  @Autowired
  SetRepository repository;
  @Autowired
  EntityRetriever retriever;

  public List<ExercisesSetsReturnDTO> createAll(List<ExercisesSetsCreateDTO> exercise_sets, TrainEntity train) {
    return exercise_sets.stream().map((exercise_dto) -> {
      return new ExercisesSetsReturnDTO(
        exercise_dto.getExercise_uuid(), 
        exercise_dto.getSets().stream().map(
          (set_dto) -> create(set_dto, train, retriever.getExerciseByUuid(exercise_dto.getExercise_uuid()))
        ).toList()
      );
    }).toList();
  }

  private SetEntity create(SetCreateRequestDTO dto, TrainEntity train, ExerciseEntity exercise){
    SetCreatePersistenceDTO create_dto = new SetCreatePersistenceDTO(dto, train, exercise);
    SetEntity entity = new SetEntity(create_dto);
    return repository.saveAndFlush(entity);
  }

  public void deleteAllWithExerciseUuid(String uuid) {
    TrainEntity entity = retriever.getTrainByUuid(uuid);
    entity.getExercises().forEach(exercise -> {
      repository.deleteAllByExercise(exercise);
    });
  }
  
}
