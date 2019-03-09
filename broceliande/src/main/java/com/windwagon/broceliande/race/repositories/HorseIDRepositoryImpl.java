package com.windwagon.broceliande.race.repositories;

import android.annotation.*;

import com.windwagon.broceliande.race.entities.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.time.temporal.*;
import java.util.*;

@Component
@SuppressLint("NewApi")
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
