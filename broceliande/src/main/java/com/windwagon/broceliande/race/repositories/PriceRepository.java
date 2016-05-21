package com.windwagon.broceliande.race.repositories;

import org.springframework.data.repository.CrudRepository;

import com.windwagon.broceliande.race.entities.BetType;
import com.windwagon.broceliande.race.entities.Price;
import com.windwagon.broceliande.race.entities.PriceName;
import com.windwagon.broceliande.race.entities.Race;

public interface PriceRepository extends CrudRepository<Price, Long> {

    Price findByRaceAndBetAndPriceNameAndTicket( Race race, BetType bet, PriceName priceName, String ticket );

}
