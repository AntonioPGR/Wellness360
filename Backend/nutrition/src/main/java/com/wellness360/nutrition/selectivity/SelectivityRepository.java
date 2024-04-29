package com.wellness360.nutrition.selectivity;

import java.util.List;
import javax.swing.text.html.parser.Entity;
import org.springframework.data.repository.NoRepositoryBean;

import com.wellness360.common.repositories.IdRepository;

@SuppressWarnings("hiding")
@NoRepositoryBean
public abstract interface SelectivityRepository<Entity> extends IdRepository<Entity> {
  List<Entity> findAllByUserId(Long id);
}