package com.windwagon.broceliande.race.repositories;

import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.windwagon.broceliande.race.entities.HorseID;
import com.windwagon.broceliande.race.entities.Sex;

@Component
public class HorseIDRepositoryImpl implements HorseIDRepositoryCustom {

    @Value( "${entities.horseid.minBirthDelta}" )
    private int birthDelta;

    @Autowired
    private HorseIDRepository horseIDRepository;

    @Override
    public HorseID findFather( HorseID child ) {
        return horseIDRepository.findFirstByNameAndSexAndBirthBefore(
                child.getFather(),
                Sex.MALE,
                Date.from( child.getBirth().toInstant().minus( birthDelta, ChronoUnit.YEARS ) ) );
    }

    @Override
    public HorseID findMother( HorseID child ) {
        return horseIDRepository.findFirstByNameAndSexAndBirthBefore(
                child.getMother(),
                Sex.FEMALE,
                Date.from( child.getBirth().toInstant().minus( birthDelta, ChronoUnit.YEARS ) ) );
    }

}
