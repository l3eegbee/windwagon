package com.windwagon.pmuportal;



import com.fasterxml.jackson.databind.*;
import com.windwagon.broceliande.race.entities.*;
import com.windwagon.broceliande.race.repositories.*;
import com.windwagon.broceliande.utils.pmu.*;
import com.windwagon.pmuportal.exceptions.*;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

//import javax.transaction.Transactional;

@Component

public class RaceParser {

    private final Logger logger = LoggerFactory.getLogger( RaceParser.class );

    @Autowired
    private RaceRepository raceRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private OddsRepository oddsRepository;

    @Autowired
    private SimpleRepository simpleRepository;

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private PMUNavigator pmuNavigator;

    @Autowired
    private PMUUtils pmuUtils;

    @Autowired
    private HorseParser horseParser;

	//10032019 TODO SUPER_QUATRE E_SUPER_QUATRE
    @PMUEnumNoValue( { "INCONNU" } )
    public enum Incident {

        @PMUEnumValue( { "NON_PARTANT", "REMBOURSE" } ) NOT_RUNNING,

        @PMUEnumValue( {
                "DISTANCE",
                "ARRETE",
                "DEROBE",
                "DEROBE_RAMENE",
                "RESTE_AU_POTEAU" } ) STOPPED,

        @PMUEnumValue( {
                "DISQUALIFIE_POUR_ALLURE_IRREGULIERE",
                "DISQUALIFIE_POTEAU_GALOP" } ) DISQUALIFIED,

        @PMUEnumValue( { "TOMBE", "TOMBE_REMONTE", "ABATTU" } ) FALLEN

    }

    public enum PriceBetType {
    	
        @PMUEnumValue( { "SIMPLE_GAGNANT", "E_SIMPLE_GAGNANT" } ) SIMPLE_GAGNANT(
                BetType.SIMPLE_GAGNANT ),

        @PMUEnumValue( { "SIMPLE_PLACE", "E_SIMPLE_PLACE" } ) SIMPLE_PLACE(BetType.SIMPLE_PLACE ),

        @PMUEnumValue( {
                "COUPLE_ORDRE",
                "COUPLE_ORDRE_INTERNATIONAL",
                "E_COUPLE_ORDRE" } ) COUPLE_ORDRE(BetType.COUPLE_ORDRE ),

        @PMUEnumValue( { "COUPLE_GAGNANT", "E_COUPLE_GAGNANT" } ) COUPLE_GAGNANT(
                BetType.COUPLE_GAGNANT ),

        @PMUEnumValue( { "COUPLE_PLACE", "E_COUPLE_PLACE" } ) COUPLE_PLACE(BetType.COUPLE_PLACE ),

        @PMUEnumValue( { "TRIO_ORDRE", "TRIO_ORDRE_INTERNATIONAL", "E_TRIO_ORDRE" } ) TRIO_ORDRE(
                BetType.TRIO_ORDRE ),

        @PMUEnumValue( { "TRIO", "E_TRIO" } ) TRIO(BetType.TRIO ),

        @PMUEnumValue( { "DEUX_SUR_QUATRE", "E_DEUX_SUR_QUATRE" } ) DEUX_SUR_QUATRE(
                BetType.DEUX_SUR_QUATRE ),

        @PMUEnumValue( { "MULTI", "E_MULTI" } ) MULTI(null ),

        @PMUEnumValue( { "MINI_MULTI", "E_MINI_MULTI" } ) MINI_MULTI(null ),

        @PMUEnumValue( { "PICK5", "E_PICK5" } ) PICK5(BetType.PICK5 ),

        @PMUEnumValue( { "TIERCE", "CLASSIC_TIERCE", "E_TIERCE", "E_CLASSIC_TIERCE" } ) TIERCE(
                BetType.TIERCE ),

        @PMUEnumValue( { "QUARTE_PLUS", "E_QUARTE_PLUS" } ) QUARTE(BetType.QUARTE ),

        @PMUEnumValue( { "SUPER_QUATRE", "E_SUPER_QUATRE" } ) SUPER_QUATRE(BetType.SUPER_QUATRE ),

        @PMUEnumValue( { "QUINTE_PLUS", "E_QUINTE_PLUS" } ) QUINTE(BetType.QUINTE );

        private BetType betType;

        PriceBetType(BetType betType) {
            this.betType = betType;
        }

        public BetType toBetType() {
            return betType;
        }
    }

    public enum MultiLibelle {

        @PMUEnumValue( {
                "MINI MULTI EN 4",
                "MULTI EN 4",
                "E-MINI MULTI EN 4",
                "E-MULTI EN 4" } ) MULTI_EN_QUATRE(BetType.MULTI_EN_QUATRE ),

        @PMUEnumValue( {
                "MINI MULTI EN 5",
                "MULTI EN 5",
                "E-MINI MULTI EN 5",
                "E-MULTI EN 5" } ) MULTI_EN_CINQ(BetType.MULTI_EN_CINQ ),

        @PMUEnumValue( {
                "MINI MULTI EN 6",
                "MULTI EN 6",
                "E-MINI MULTI EN 6",
                "E-MULTI EN 6" } ) MULTI_EN_SIX(BetType.MULTI_EN_SIX ),

        @PMUEnumValue( { "MULTI EN 7", "E-MULTI EN 7" } ) MULTI_EN_SEPT(BetType.MULTI_EN_SEPT ),

        @PMUEnumValue( {
                "MINI MULTI EN 4 DEGRADE",
                "MULTI EN 4 DEGRADE",
                "E-MINI MULTI EN 4 DEGRADE",
                "E-MULTI EN 4 DEGRADE" } ) MULTI_EN_QUATRE_DEGRADE(
                        BetType.MULTI_EN_QUATRE,
                        PriceName.DEGRADE ),

        @PMUEnumValue( {
                "MINI MULTI EN 5 DEGRADE",
                "MULTI EN 5 DEGRADE",
                "E-MINI MULTI EN 5 DEGRADE",
                "E-MULTI EN 5 DEGRADE" } ) MULTI_EN_CINQ_DEGRADE(
                        BetType.MULTI_EN_CINQ,
                        PriceName.DEGRADE ),

        @PMUEnumValue( {
                "MINI MULTI EN 6 DEGRADE",
                "MULTI EN 6 DEGRADE",
                "E-MINI MULTI EN 6 DEGRADE",
                "E-MULTI EN 6 DEGRADE" } ) MULTI_EN_SIX_DEGRADE(
                        BetType.MULTI_EN_SIX,
                        PriceName.DEGRADE ),

        @PMUEnumValue( { "MULTI EN 7 DEGRADE", "E-MULTI EN 7 DEGRADE" } ) MULTI_EN_SEPT_DEGRADE(
                BetType.MULTI_EN_SEPT,
                PriceName.DEGRADE ),

        @PMUEnumValue( "REMBOURSEMENT TOTAL" ) MULTI_EN_QUATRE_REMB(
                BetType.MULTI_EN_QUATRE,
                PriceName.REMBOURSEMENT ),

        @PMUEnumValue( "REMBOURSEMENT TOTAL" ) MULTI_EN_CINQ_REMB(
                BetType.MULTI_EN_CINQ,
                PriceName.REMBOURSEMENT ),

        @PMUEnumValue( "REMBOURSEMENT TOTAL" ) MULTI_EN_SIX_REMB(
                BetType.MULTI_EN_SIX,
                PriceName.REMBOURSEMENT ),

        @PMUEnumValue( "REMBOURSEMENT TOTAL" ) MULTI_EN_SEPT_REMB(
                BetType.MULTI_EN_SEPT,
                PriceName.REMBOURSEMENT );

        private BetType betType;

        private PriceName priceName = PriceName.DIRECT;

        MultiLibelle(BetType betType) {
            this.betType = betType;
        }

        MultiLibelle(BetType betType, PriceName priceName) {
            this.betType = betType;
            this.priceName = priceName;
        }

        public BetType toBetType() {
            return betType;
        }

        public PriceName toPriceName() {
            return priceName;
        }

    }

    @Transactional
    public synchronized Race updateRace( Race race ) throws PMUError {

        JsonNode jsonRace = pmuNavigator.getJSONRace(
                race.getMeeting().getDate(),
                race.getMeeting().getNumber(),
                race.getNumber() );

        parse( race, jsonRace );

        raceRepository.save( race );

        return race;

    }

    @Transactional
    public synchronized Race parseRace( Meeting meeting, JsonNode raceNode ) throws PMUError {

        // number
        int rnum = raceNode.at( "/numOrdre" ).asInt();

        Race race = null;

        if( meeting.getId() != null )
            race = raceRepository.findByMeetingAndNumber( meeting, rnum );

        if( race == null ) {

            race = new Race();

            race.setNumber( rnum );
            race.setMeeting( meeting );

        }

        parse( race, raceNode );

        return race;

    }

    private synchronized void parse(Race race, JsonNode raceNode ) throws PMUError {

        logger.info( "Parse {}", race );

        int rnum = race.getNumber();
        Meeting meeting = race.getMeeting();

        try {

            // name
            String name = pmuUtils.asText( raceNode.at( "/libelle" ) );
            pmuUtils.shouldNotBeModified( race, race.getName(), name );
            race.setName( name );
            logger.trace( "Parse {}: name: [{}]", race, name );

            // status
            RaceStatus status =
                    pmuUtils.findPMU( RaceStatus.class, raceNode.at( "/categorieStatut" ) );
            race.setStatus( status );
            logger.trace( "Parse {}: status: [{}]", race, status );

            // check status depending prices disponibility

            JsonNode pricesNode = null;

            if( race.getStatus() == RaceStatus.FINISHED )
                try {
                    pricesNode = pmuNavigator.getJSONPrices( meeting.getDate(), meeting.getNumber(), rnum );
                } catch( PMUNoContent ex ) {
                    race.setStatus( RaceStatus.STARTED );
                }

            // start
            Date raceStart = new Date( raceNode.at( "/heureDepart" ).asLong() );
            race.setStart( raceStart );
            logger.trace( "Parse {}: start: [{}]", race, raceStart );

            // distance
            Double distance = raceNode.at( "/distance" ).asDouble();
            pmuUtils.shouldNotBeModified( race, race.getDistance(), distance );
            race.setDistance( distance );
            logger.trace( "Parse {}: distance: [{}]", race, distance );

            // benefit
            Double benefit = raceNode.at( "/montantTotalOffert" ).asDouble();
            pmuUtils.shouldNotBeModified( race, race.getBenefit(), benefit );
            race.setBenefit( benefit );
            logger.trace( "Parse {}: benefit: [{}]", race, benefit );

            // discipline
            Discipline discipline =
                    pmuUtils.findPMU( Discipline.class, raceNode.at( "/discipline" ) );
            pmuUtils.shouldNotBeModified( race, race.getDiscipline(), discipline );
            race.setDiscipline( discipline );
            logger.trace( "Parse {}: discipline: [{}]", race, discipline );

            // types
            JsonNode typesNode = raceNode.at( "/categorieParticularite" );
            Set<Type> types = EnumSet.noneOf( Type.class );
            if( !typesNode.isMissingNode() )
                types.addAll( pmuUtils.findAllPMU( Type.class, typesNode ) );
            pmuUtils.shouldNotBeModified( race, race.getTypes(), types );
            pmuUtils.updateSet( race::getTypes, race::setTypes, types );
            logger.trace( "Parse {}: types: {}", race, types );

            // bets
            Set<BetType> betTypes = EnumSet.noneOf( BetType.class );
            for( JsonNode betTypeNode : raceNode.at( "/paris" ) )
                betTypes.addAll(
                        pmuUtils.findAllPMU(
                                BetType.class,
                                pmuUtils.asText( betTypeNode.at( "/typePari" ) ) ) );
            pmuUtils.shouldNotBeModified( race, race.getBets(), betTypes );
            pmuUtils.updateSet( race::getBets, race::setBets, betTypes );
            logger.trace( "Parse {}: bets: {}", race, betTypes );

            // load useful infos
            JsonNode allHorsesNode =
                    pmuNavigator.getJSONHorses( meeting.getDate(), meeting.getNumber(), rnum );
            JsonNode totalBetsNode =
                    pmuNavigator.getJSONTotalBets( meeting.getDate(), meeting.getNumber(), rnum );

            JsonNode horsesNode = allHorsesNode.at( "/participants" );
            JsonNode stablesNode = allHorsesNode.at( "/ecuries" );

            //
            // horses
            //

            SortedSet<Horse> horses = new TreeSet<>();

            SortedSet<Place> places = new TreeSet<>();

            List<Integer> stopped = new LinkedList<>();
            List<Integer> disqualified = new LinkedList<>();
            List<Integer> fallen = new LinkedList<>();

            for( JsonNode horseNode : horsesNode ) {

                // parse horse
                Horse horse = horseParser.parseHorse( race, horseNode );
                horses.add( horse );

                // place
                JsonNode finishNode = horseNode.at( "/ordreArrivee" );
                if( !finishNode.isMissingNode() ) {

                    int number = finishNode.asInt();

                    Place place = null;

                    if( race.getId() != null )
                        place = placeRepository
                                .findByRaceAndNumberAndHorse( race, number, horse.getNumber() );

                    if( place == null ) {

                        place = new Place();

                        place.setRace( race );
                        place.setNumber( number );
                        place.setHorse( horse.getNumber() );

                    }

                    logger.trace(
                            "Parse {}: place #{}: horse: [{}]",
                            race,
                            number,
                            horse.getNumber() );

                    JsonNode timeNode = horseNode.at( "/tempsObtenu" );
                    if( !timeNode.isMissingNode() ) {
                        Integer placeDuration = timeNode.asInt();
                        place.setDuration( placeDuration );
                        logger.trace(
                                "Parse {}: place #{}: duration: [{}]",
                                race,
                                number,
                                placeDuration );
                    }

                    JsonNode distanceNode = horseNode.at( "/distanceChevalPrecedent/identifiant" );
                    if( !distanceNode.isMissingNode() ) {
                        String placeDistance = pmuUtils.asText( distanceNode );
                        place.setDistance( placeDistance );
                        logger.trace(
                                "Parse {}: place #{}: distance: [{}]",
                                race,
                                number,
                                placeDistance );
                    }

                    places.add( place );

                }

                // stopped - disqualified - fallen

                JsonNode incidentNode = horseNode.at( "/incident" );
                if( !incidentNode.isMissingNode() ) {

                    Incident inc = pmuUtils.findPMU( Incident.class, incidentNode );

                    if( inc == Incident.STOPPED )
                        stopped.add( horse.getNumber() );

                    else if( inc == Incident.DISQUALIFIED )
                        disqualified.add( horse.getNumber() );

                    else if( inc == Incident.FALLEN )
                        fallen.add( horse.getNumber() );

                }

            }

            pmuUtils.updateSet( race::getHorses, race::setHorses, horses );
            pmuUtils.updateSet( race::getPlaces, race::setPlaces, places );

            logger.trace( "Parse {}: stopped: {}", race, stopped );
            logger.trace( "Parse {}: disqualified: {}", race, disqualified );
            logger.trace( "Parse {}: fallen: {}", race, fallen );

            if( !stopped.isEmpty() )
                race.setStopped(
                        stopped.stream().map( v -> Integer.toString( v ) ).collect(
                                Collectors.joining( " " ) ) );
            if( !disqualified.isEmpty() )
                race.setDisqualified(
                        disqualified.stream().map( v -> Integer.toString( v ) ).collect(
                                Collectors.joining( " " ) ) );
            if( !fallen.isEmpty() )
                race.setFallen(
                        fallen.stream().map( v -> Integer.toString( v ) ).collect(
                                Collectors.joining( " " ) ) );

            //
            // odds
            //

            SortedSet<Odds> oddsSet = race.getOdds();
            if( oddsSet == null ) {
                oddsSet = new TreeSet<>();
                race.setOdds( oddsSet );
            }

            // ref odds
            Odds refOdds = parseOdds( horsesNode, stablesNode, race, "dernierRapportReference" );
            if( refOdds != null )
                oddsSet.add( refOdds );

            // current odds
            Odds currOdds = parseOdds( horsesNode, stablesNode, race, "dernierRapportDirect" );
            if( currOdds != null ) {

                for( JsonNode totalNode : totalBetsNode ) {
                    if( "SIMPLE_GAGNANT"
                            .equals( pmuUtils.asText( totalNode.at( "/typePari" ) ) ) ) {
                        Double currOddsTotal = totalNode.at( "/totalEnjeu" ).asDouble() / 100d;
                        currOdds.setTotal( currOddsTotal );
                        logger.trace(
                                "Parse {}: odds at {}: total: [{}]",
                                race,
                                currOdds.getDate(),
                                currOddsTotal );
                        break;
                    }
                }

                oddsSet.add( currOdds );

            }

            //
            // prices
            //

            SortedSet<Price> prices = new TreeSet<>();

            if( race.getStatus() == RaceStatus.FINISHED ) {

                // map num <-> horse
                Map<Integer, Horse> numHorseMap = new HashMap<Integer, Horse>();
                for( Horse horse : horses )
                    numHorseMap.put( horse.getNumber(), horse );

                for( JsonNode betNode : pricesNode ) {

                    PriceBetType priceBetType = pmuUtils.findPMU(
                            PriceBetType.class,
                            pmuUtils.asText( betNode.at( "/typePari" ) ) );

                    for( JsonNode priceNode : betNode.at( "/rapports" ) ) {

                        String libelle = pmuUtils.asText( priceNode.at( "/libelle" ) );

                        switch( priceBetType ) {

                            case SIMPLE_GAGNANT:
                            case SIMPLE_PLACE:
                            case COUPLE_ORDRE:
                            case COUPLE_GAGNANT:
                            case COUPLE_PLACE:
                            case TRIO_ORDRE:
                            case TRIO:
                            case DEUX_SUR_QUATRE:
                            case PICK5:
                            case TIERCE:
                            case QUARTE:
                            case SUPER_QUATRE:
                            case QUINTE:
                                PriceName priceName = pmuUtils.findPMU( PriceName.class, libelle );
                                if( priceName != null )
                                    prices.add(
                                            loadPrice(
                                                    race,
                                                    numHorseMap,
                                                    priceBetType.toBetType(),
                                                    priceName,
                                                    priceNode ) );
                                break;

                            case MULTI:
                            case MINI_MULTI:
                                for( MultiLibelle lib : pmuUtils
                                        .findAllPMU( MultiLibelle.class, libelle ) )
                                    if( race.getBets().contains( lib.toBetType() ) )
                                        prices.add(
                                                loadPrice(
                                                        race,
                                                        numHorseMap,
                                                        lib.toBetType(),
                                                        lib.toPriceName(),
                                                        priceNode ) );
                                break;
						
							default:
							break;

                        }

                    }

                }

            }

            pmuUtils.updateSet( race::getPrices, race::setPrices, prices );

        } catch( PMUNoContent | PMUMethodFailureResponse ex ) {
            throw ex;
        } catch( PMUError ex ) {
            throw new PMUError( "Error during parse of " + race, ex );
        }

    }

    private Date getOddsDate( JsonNode horsesNode, JsonNode stablesNode, String key ) {

        for( JsonNode horseNode : horsesNode ) {
            JsonNode timestampNode = horseNode.at( "/" + key + "/dateRapport" );
            if( !timestampNode.isMissingNode() )
                return new Date( timestampNode.asLong() );
        }

        for( JsonNode stableNode : stablesNode ) {
            JsonNode timestampNode = stableNode.at( "/" + key + "/dateRapport" );
            if( !timestampNode.isMissingNode() )
                return new Date( timestampNode.asLong() );
        }

        return null;

    }

    private Odds parseOdds( JsonNode horsesNode, JsonNode stablesNode, Race race, String key )
            throws PMUError {

        Date date = getOddsDate( horsesNode, stablesNode, key );
        if( date == null )
            return null;

        Odds odds = null;

        if( race.getId() != null )
            odds = oddsRepository.findByRaceAndDate( race, date );

        if( odds == null ) {

            odds = new Odds();

            odds.setRace( race );
            odds.setDate( date );

        }

        logger.trace( "Parse {}: odds at {}", race, date );

        SortedSet<Simple> simples = new TreeSet<Simple>();

        // horses
        for( JsonNode horseNode : horsesNode ) {

            String num = pmuUtils.asText( horseNode.at( "/numPmu" ) );
            JsonNode valueNode = horseNode.at( "/" + key + "/rapport" );

            if( !valueNode.isMissingNode() ) {

                Double value = valueNode.asDouble();

                logger.trace( "Parse {}: odds at {}: #{}: {}", race, date, num, value );

                Simple simple = null;

                if( odds.getId() != null )
                    simple = simpleRepository.findByOddsAndNumber( odds, num );

                if( simple == null ) {

                    simple = new Simple();

                    simple.setOdds( odds );
                    simple.setNumber( num );

                }

                simple.setSimple( value );

                simples.add( simple );

            }
        }

        // stables
        for( JsonNode stableNode : stablesNode ) {

            String num = pmuUtils.asText( stableNode.at( "/nom" ) );
            JsonNode valueNode = stableNode.at( "/" + key + "/rapport" );

            if( !valueNode.isMissingNode() ) {

                Double value = valueNode.asDouble();

                logger.trace( "Parse {}: odds at {}: #{}: {}", race, date, num, value );

                Simple simple = null;

                if( odds.getId() != null )
                    simple = simpleRepository.findByOddsAndNumber( odds, num );

                if( simple == null ) {

                    simple = new Simple();

                    simple.setOdds( odds );
                    simple.setNumber( num );

                }

                simple.setSimple( value );

                simples.add( simple );

            }
        }

        pmuUtils.updateSet( odds::getSimples, odds::setSimples, simples );

        return odds;

    }

    private static final Pattern NUMBER_PATTERN = Pattern.compile( "\\d+" );

    public Price loadPrice(
            Race race,
            Map<Integer, Horse> numHorseMap,
            BetType betType,
            PriceName priceName,
            JsonNode priceNode ) throws PMUError {

        List<String> ticketList = new LinkedList<>();
        Matcher numberMatcher = NUMBER_PATTERN
                .matcher( pmuUtils.protect( priceNode.at( "/combinaison" ).toString() ) );
        while( numberMatcher.find() )
            ticketList.add( numberMatcher.group() );

        String ticket = ticketList.stream().collect( Collectors.joining( " " ) );

        Price price = null;

        if( race.getId() != null )
            price = priceRepository
                    .findByRaceAndBetAndPriceNameAndTicket( race, betType, priceName, ticket );

        if( price == null ) {

            price = new Price();

            price.setRace( race );
            price.setBet( betType );
            price.setPriceName( priceName );
            price.setTicket( ticket );

        }

        Double value = priceNode.at( "/dividendePourUnEuro" ).asDouble() / 100d;
        price.setPrice( value );

        logger.trace( "Parse {}: price {}-{} [{}]: {}", race, betType, priceName, ticket, value );

        return price;

    }

}
