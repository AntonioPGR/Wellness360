package com.wellness360.nutrition.app.selectivity;

import java.util.List;
import javax.swing.text.html.parser.Entity;
import org.springframework.data.repository.NoRepositoryBean;

import com.wellness360.nutrition.common.crud_bases.repositories.UUIDRepository;

@SuppressWarnings("hiding")
@NoRepositoryBean
public abstract interface SelectivityRepository<Entity> extends UUIDRepository<Entity> {
  List<Entity> findAllByUserId(Long id);
}