package com.windwagon.broceliande.knights.repositories;

import org.springframework.data.repository.NoRepositoryBean;

import com.windwagon.broceliande.knights.entities.Task;

@NoRepositoryBean
public interface TaskRepository<T extends Task> extends ActorDataRepository<T> {}
