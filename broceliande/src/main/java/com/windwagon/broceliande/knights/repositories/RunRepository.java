package com.windwagon.broceliande.knights.repositories;

import org.springframework.data.repository.NoRepositoryBean;

import com.windwagon.broceliande.knights.entities.Run;

@NoRepositoryBean
public interface RunRepository <R extends Run> extends LongIdentifiedRepository<R> {}
