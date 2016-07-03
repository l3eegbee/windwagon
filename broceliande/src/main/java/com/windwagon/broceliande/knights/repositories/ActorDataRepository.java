package com.windwagon.broceliande.knights.repositories;

import org.springframework.data.repository.NoRepositoryBean;

import com.windwagon.broceliande.knights.entities.ActorData;

@NoRepositoryBean
public interface ActorDataRepository <A extends ActorData> extends LongIdentifiedRepository<A> {}
