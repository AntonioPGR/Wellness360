package com.wellness360.users.app.users;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellness360.users.app.users.dtos.UserCreateDTO;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.None;
import com.wellness360.users.app.users.dtos.UserLoginDTO;
import com.wellness360.users.app.users.dtos.UserReturnTokenDTO;
import com.wellness360.users.app.users.dtos.UserReturnUuidDTO;
import com.wellness360.users.app.users.dtos.UserUpdateDTO;
import com.wellness360.users.app.users.user_basic.dtos.UserBasicReturnDTO;
import com.wellness360.users.app.users.user_full.dtos.UserFullReturnDTO;
import com.wellness360.users.app.users.dtos.UserUpdateAdminDTO;
import com.wellness360.users.packages.crud.controllers.CrudStorageController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("${path.users}")
public class UserController extends CrudStorageController<
  UserCreateDTO,
  UserUpdateAdminDTO,
  UserFullReturnDTO,
  UserService
> {

  // ADMIN METHODS
  @GetMapping("/admin")
  public ResponseEntity<Page<UserBasicReturnDTO>> getAllBasic(Pageable pageable) {
    Page<UserBasicReturnDTO> return_dto = service.getAllBasic(pageable);
    return ResponseEntity.ok().body(return_dto);
  }

  @Override
  @GetMapping("/admin/full")
  public ResponseEntity<Page<UserFullReturnDTO>> getAll(Pageable pageable) {
    return super.getAll(pageable);
  }

  @GetMapping("/admin/full/{uuid}")
  public ResponseEntity<UserFullReturnDTO> getMethodName(@PathVariable("uuid") String uuid) {
    UserFullReturnDTO return_dto = service.getByUuid(uuid);
    return ResponseEntity.ok().body(return_dto);
  }
  
  @Override
  @PutMapping(path="/admin", consumes={MediaType.MULTIPART_FORM_DATA_VALUE})
  public ResponseEntity<UserFullReturnDTO> update(@ModelAttribute UserUpdateAdminDTO request_dto) {
    return super.update(request_dto);
  }

  @DeleteMapping("/admin/{uuid}")
  public ResponseEntity<None> delete(@PathVariable String uuid) {
    return super.delete(uuid);
  } 


  // CURRENT USER METHODS
  @PutMapping
  public ResponseEntity<UserFullReturnDTO> updateCurrent(UserUpdateDTO request_dto) {
    UserFullReturnDTO return_dto = service.updateCurrent(request_dto);
    return ResponseEntity.ok().body(return_dto);
  }

  @GetMapping
  public ResponseEntity<UserBasicReturnDTO> getUniqueBasic() {
    UserBasicReturnDTO return_dto = service.getCurrentBasic();
    return ResponseEntity.ok().body(return_dto);
  }

  @GetMapping("/full")
  public ResponseEntity<UserFullReturnDTO> getUnique() {
    UserFullReturnDTO return_dto = service.getCurrentFull();
    return ResponseEntity.ok().body(return_dto);
  }

  @DeleteMapping
  public ResponseEntity<None> deactivate() {
    service.deactivate();
    return ResponseEntity.noContent().build();
  }

  @PostMapping("/login")
  public ResponseEntity<UserReturnTokenDTO> login(@RequestBody UserLoginDTO dto) {
    UserReturnTokenDTO token = service.authenticate(dto);
    return ResponseEntity.ok().body(token);
  }
  
  @PostMapping("/authenticate")
  public UserReturnUuidDTO authenticate() {
    return service.getCurrentUserUuid();
  }
  

}
