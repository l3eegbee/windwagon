package com.windwagon.pmuportal;

import android.annotation.*;

import com.fasterxml.jackson.databind.*;
import com.windwagon.broceliande.race.entities.*;
import com.windwagon.broceliande.race.repositories.*;
import com.windwagon.pmuportal.exceptions.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

import static com.windwagon.logres.date.DateConverter.*;

@SuppressLint("NewApi")
@Component
public class HorseParser {

    @Autowired
    private HorseRepository horseRepository;

    @Autowired
    private HorseIDRepository horseIDRepository;

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private RancherRepository rancherRepository;

    @Autowired
    private JockeyRepository jockeyRepository;

    @Autowired
    private PMUUtils pmuUtils;

    @Transactional
    public synchronized Horse parseHorse( Race race, JsonNode horseNode ) throws PMUError {

        // number
        int hnum = horseNode.at( "/numPmu" ).asInt();

        Horse horse = null;

        if( race.getId() != null )
            horse = horseRepository.findByRaceAndNumber( race, hnum );

        if( horse == null ) {

            horse = new Horse();

            horse.setRace( race );
            horse.setNumber( hnum );

        }

        try {

            //
            // horse id
            //

            // name
            String name = pmuUtils.asText( horseNode.at( "/nom" ) );

            // birth
            int age = horseNode.at( "/age" ).asInt();
            Date birth = toDate( startOfTheYear( race.getStart() ).minusYears( age ) );

            // sex
            Sex sex = pmuUtils.findPMU( Sex.class, horseNode.at( "/sexe" ) );
            Sex mfSex = sex == Sex.FEMALE ? Sex.FEMALE : Sex.MALE;

            // parents
            String father = pmuUtils.asText( horseNode.at( "/nomPere" ) );
            String mother = pmuUtils.asText( horseNode.at( "/nomMere" ) );

            HorseID horseID = horseIDRepository.findByNameAndBirthAndSexAndFatherAndMother(
                    name,
                    birth,
                    mfSex,
                    father,
                    mother );

            if( horseID == null ) {

                HorseID switchedHorsedID =
                        horseIDRepository.findByNameAndBirthAndSexAndFatherAndMother(
                                name,
                                birth,
                                mfSex,
                                mother,
                                father );

                if( switchedHorsedID == null ) {

                    // new HorseID

                    horseID = new HorseID();

                    horseID.setName( name );
                    horseID.setBirth( birth );
                    horseID.setSex( mfSex );
                    horseID.setFather( father );
                    horseID.setMother( mother );
                    horseID.setFiability( 1 );

                    horseID = horseIDRepository.save( horseID );

                } else if( switchedHorsedID.getFiability() == 0 ) {

                    // switch!

                    horseID = switchedHorsedID;
                    horseID.setFather( father );
                    horseID.setMother( mother );
                    horseID.setFiability( 1 );

                } else {

                    // decrease fiability

                    horseID = switchedHorsedID;
                    horseID.setFiability( horseID.getFiability() - 1 );

                }

            } else {

                // increase fiability

                horseID.setFiability( horseID.getFiability() + 1 );

            }

            // gelding
            if( sex == Sex.GELDING ) {
                Date gelding = horseID.getGelding();
                Date now = race.getMeeting().getDate();
                if( gelding == null || gelding.after( now ) )
                    horseID.setGelding( now ); // MAZEL TOV!
            }

            // breed
            JsonNode breedNode = horseNode.at( "/race" );
            if( !breedNode.isMissingNode() ) {
                Breed breed = pmuUtils.findPMU( Breed.class, breedNode );
                Breed horseBreed = horseID.getBreed();
                if( horseBreed != Breed.INCONNU && breed != Breed.INCONNU )
                    pmuUtils.shouldNotBeModified( horseID, horseID.getBreed(), breed );
                if( horseBreed == null || breed != Breed.INCONNU )
                    horseID.setBreed( breed );
            }

            // coat
            JsonNode coatNode = horseNode.at( "/robe/libelleCourt" );
            if( !coatNode.isMissingNode() ) {
                Coat coat = pmuUtils.findPMU( Coat.class, coatNode );
                Coat horseCoat = horseID.getCoat();
                if( horseCoat != Coat.INCONNU && coat != Coat.INCONNU )
                    pmuUtils.shouldNotBeModified( horseID, horseID.getCoat(), coat );
                if( horseCoat == null || coat != Coat.INCONNU )
                    horseID.setCoat( coat );
            }

            horse.setHorseID( horseID );

            //
            // horse
            //

            // runner
            horse.setRunner( pmuUtils.asText( horseNode.at( "/statut" ) ).equals( "PARTANT" ) );

            // supplemented
            JsonNode supplementedNode = horseNode.at( "/engagement" );
            if( !supplementedNode.isMissingNode() )
                horse.setSupplemented( supplementedNode.asBoolean() );
            else
                horse.setSupplemented( false );

            // pregnant
            JsonNode pregnantNode = horseNode.at( "/jumentPleine" );
            if( !pregnantNode.isMissingNode() )
                horse.setPregnant( pregnantNode.asBoolean() );
            else
                horse.setPregnant( false );

            // stall
            JsonNode stallNode = horseNode.at( "/placeCorde" );
            if( !stallNode.isMissingNode() )
                horse.setStall( stallNode.asInt() );

            // stable
            JsonNode stableNode = horseNode.at( "/ecurie" );
            if( !stableNode.isMissingNode() )
                horse.setStable( pmuUtils.asText( stableNode ) );

            // weight
            JsonNode weightNode = horseNode.at( "/handicapPoids" );
            if( !weightNode.isMissingNode() )
                horse.setWeight( weightNode.asDouble() / 10L);

            // distance
            JsonNode distanceNode = horseNode.at( "/handicapDistance" );
            if( !distanceNode.isMissingNode() )
                horse.setDistance( distanceNode.asDouble() );
            else
                horse.setDistance( race.getDistance() );

            // career profit
            JsonNode careerProfitNode = horseNode.at( "/gainsParticipant/gainsCarriere" );
            if( !careerProfitNode.isMissingNode() )
                horse.setCareerProfit( careerProfitNode.asDouble() );

            // previous year profit
            JsonNode previousYearProfitNode =
                    horseNode.at( "/gainsParticipant/gainsAnneePrecedente" );
            if( !previousYearProfitNode.isMissingNode() )
                horse.setPreviousYearProfit( previousYearProfitNode.asDouble() );

            // year profit
            JsonNode yearProfitNode = horseNode.at( "/gainsParticipant/gainsAnneeEnCours" );
            if( !yearProfitNode.isMissingNode() )
                horse.setYearProfit( yearProfitNode.asDouble() );

            // victory profit
            JsonNode victoryProfitNode = horseNode.at( "/gainsParticipant/gainsVictoires" );
            if( !victoryProfitNode.isMissingNode() )
                horse.setVictoryProfit( victoryProfitNode.asDouble() );

            // place profit
            JsonNode placeProfitNode = horseNode.at( "/gainsParticipant/gainsPlace" );
            if( !placeProfitNode.isMissingNode() )
                horse.setPlaceProfit( placeProfitNode.asDouble() );

            // horseshoe
            JsonNode horseshoeNode = horseNode.at( "/deferre" );
            if( !horseshoeNode.isMissingNode() )
                horse.setHorseshoe( pmuUtils.findPMU( Horseshoe.class, horseshoeNode ) );
            else
                horse.setHorseshoe( Horseshoe.ALL );

            // blinder
            JsonNode blinderNode = horseNode.at( "/oeilleres" );
            if( !blinderNode.isMissingNode() )
                horse.setBlinder( pmuUtils.findPMU( Blinder.class, blinderNode ) );
            else
                horse.setBlinder( Blinder.NONE );

            // trainer
            JsonNode trainerNode = horseNode.at( "/entraineur" );
            if( !trainerNode.isMissingNode() ) {

                String trainerName = pmuUtils.asText( trainerNode );

                Trainer trainer = trainerRepository.findByName( trainerName );
                if( trainer == null ) {
                    trainer = new Trainer();
                    trainer.setName( trainerName );
                    trainer = trainerRepository.save( trainer );
                }

                horse.setTrainer( trainer );

            }

            // owner
            JsonNode ownerNode = horseNode.at( "/proprietaire" );
            if( !ownerNode.isMissingNode() ) {

                String ownerName = pmuUtils.asText( ownerNode );

                Owner owner = ownerRepository.findByName( ownerName );
                if( owner == null ) {
                    owner = new Owner();
                    owner.setName( ownerName );
                    owner = ownerRepository.save( owner );
                }

                horse.setOwner( owner );

            }

            // rancher
            JsonNode rancherNode = horseNode.at( "/eleveur" );
            if( !rancherNode.isMissingNode() ) {

                String rancherName = pmuUtils.asText( rancherNode );

                Rancher rancher = rancherRepository.findByName( rancherName );
                if( rancher == null ) {
                    rancher = new Rancher();
                    rancher.setName( rancherName );
                    rancher = rancherRepository.save( rancher );
                }

                horse.setRancher( rancher );

            }

            // jockey
            JsonNode jockeyNode = horseNode.at( "/driver" );
            if( !jockeyNode.isMissingNode() ) {

                String jockeyName = pmuUtils.asText( jockeyNode );

                Jockey jockey = jockeyRepository.findByName( jockeyName );
                if( jockey == null ) {
                    jockey = new Jockey();
                    jockey.setName( jockeyName );
                    jockey = jockeyRepository.save( jockey );
                }

                horse.setJockey( jockey );

            }

        } catch( PMUError ex ) {
            throw new PMUError( "Error during parse of " + horse, ex );
        }

        return horse;

    }

}
