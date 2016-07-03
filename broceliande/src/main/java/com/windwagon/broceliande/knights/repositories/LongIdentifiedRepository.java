package com.windwagon.broceliande.knights.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface LongIdentifiedRepository<T> extends CrudRepository<T, Long> {}
