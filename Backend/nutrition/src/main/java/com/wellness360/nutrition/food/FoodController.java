package com.wellness360.nutrition.food;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wellness360.nutrition.food.DTO.FoodCreateDTO;
import com.wellness360.nutrition.food.DTO.FoodReturnDTO;
import com.wellness360.nutrition.food.DTO.FoodUpdateDTO;
import com.wellness360.tools.URICreator;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class FoodController {

  @Autowired
  FoodRepository food_respository;
  @Autowired
  URICreator uri_creator;
  
  @GetMapping("/nutrition/food")
  ResponseEntity<List<FoodDocument>> GetAll(){
    List<FoodDocument> food_list = food_respository.findAll();
    return ResponseEntity.ok().body(food_list);
  }

  @GetMapping("/nutrition/food/{id}")
  ResponseEntity<FoodDocument> GetOne(@PathVariable String id){
    Optional<FoodDocument> search_result = food_respository.findById(id);
    if(search_result.isPresent()){
      return ResponseEntity.ok().body(search_result.get());
    }
    return ResponseEntity.notFound().build();
  }

  // @GetMapping("/nutrition/food/search")
  // ResponseEntity<FoodDocument> Search(FoodSearchParams searchParams){
  //   Optional<FoodDocument> search_result = food_respository.findById(id);
  //   if(search_result.isPresent()){
  //     return ResponseEntity.ok().body(search_result.get());
  //   }
  //   return ResponseEntity.notFound().build();
  // }

  @PostMapping("/nutrition/food")
  ResponseEntity<Object> Create(@RequestBody FoodCreateDTO dto) throws URISyntaxException{
    FoodDocument food = new FoodDocument(dto);
    FoodDocument created_food = food_respository.save(food);
    URI item_uri = uri_creator.createUriToCreatedElement("/nutrition/food", created_food.getId());
    return ResponseEntity.created(item_uri).build();
  }

  @PutMapping("/nutrition/food/{id}")
  public ResponseEntity<FoodReturnDTO> Update(@PathVariable String id, @RequestBody FoodUpdateDTO dto) {
    Optional<FoodDocument> search_result = food_respository.findById(id);
    if(search_result.isPresent()){
      search_result.get().update(dto);
      return ResponseEntity.ok().body(new FoodReturnDTO(search_result.get()));
    }
    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("/nutrition/food/{id}")
  public ResponseEntity<Object> Update(@PathVariable String id) {
    Optional<FoodDocument> search_result = food_respository.findById(id);
    if(search_result.isPresent()){
      food_respository.deleteById(id);
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }

}
