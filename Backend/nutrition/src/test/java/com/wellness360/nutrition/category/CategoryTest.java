package com.wellness360.nutrition.category;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.wellness360.nutrition.category.dtos.CategoryCreateDTO;

public class CategoryTest {
  
  String dft_name = "Categoria 1";
  String dft_description = "Descrição";
  String dft_image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpFN1Tvo80rYwu-eXsDNNzsuPITOdtyRPlYIsIqKaIbw&s";

  @Test
  public void assertCategoryIsBeingCreateCorrectly() {
    CategoryCreateDTO dto = new CategoryCreateDTO(
      dft_name,
      dft_description,
      dft_image
    );
    CategoryEntity category = new CategoryEntity(dto);
    assertEquals(category.getName(), dft_name);
    assertEquals(category.getDescription(), dft_description);
    assertEquals(category.getImage_url(), dft_image);

    // insert in database and assert id and uuid is not null;
  }

  // @Test
  // public void assertNullDescriptionIsAccepted() {
  //   CategoryEntity category = new CategoryEntity(
  //     dft_name,
  //     null,
  //     dft_image
  //   );
  //   assertEquals(category.getName(), dft_name);
  //   assertEquals(category.getDescription(), null);
  //   assertEquals(category.getImage_url(), dft_image);
  // }

  // @Test
  // public void assertNullNameIsNOTAccepted() {
  //   CategoryEntity category = new CategoryEntity(
  //     null,
  //     dft_description,
  //     dft_image
  //   );
  //   assertEquals(category.getName(), null);
  //   assertEquals(category.getDescription(), dft_description);
  //   assertEquals(category.getImage_url(), dft_image);
  // }

  // @Test
  // public void assertNullImageIsNOTAccepted() {
  //   CategoryEntity category = new CategoryEntity(
  //     dft_name,
  //     dft_description,
  //     null
  //   );
  //   assertEquals(category.getName(), dft_name);
  //   assertEquals(category.getDescription(), dft_description);
  //   assertEquals(category.getImage_url(), null);
  // }

}
