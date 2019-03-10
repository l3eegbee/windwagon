package com.windwagon.pmuportal;


import com.fasterxml.jackson.databind.*;
import com.windwagon.broceliande.utils.pmu.*;
import com.windwagon.pmuportal.exceptions.*;

import org.slf4j.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.function.*;

@Component
public class PMUUtils {

    public static final Logger logger = LoggerFactory.getLogger( PMUUtils.class );

    public String protect( String str ) {

        str = str.replace( '\u00A0', ' ' ); // espace insecable
        str = str.replace( '\u00B0', ' ' ); // symbol degree
        str = str.replace( '\u20AC', 'e' ); // symbol euro
        str = str.replace( "\u0152", "OE" ); // e dans l'o majuscule
        str = str.replace( "\u0153", "oe" ); // e dans l'o minuscule
        str = str.replace( 'ç', 'c' ); // c cedille
        str = str.replace( "`", "'" ); // apostrophe

        // erreur d'encodage
        str = str.replace( "ýý", "e" );
        str = str.replace( "ìì", "e" );
        str = str.replace( "îî", "e" );
        str = str.replace( "ïï", "e" );
        str = str.replace( "ii", "e" );
        str = str.replace( "Ñ", "e" );
        str = str.replace( "\\", "e" );
        str = str.replace( "Ó", "i" );
        str = str.replace( "÷", "o" );
        str = str.replace( "Â©", "'" );
        str = str.replace( "©", "'" );

        // accents
        str = str.replace( 'à', 'a' );
        str = str.replace( 'À', 'a' );
        str = str.replace( 'â', 'a' );
        str = str.replace( 'Â', 'a' );
        str = str.replace( 'ä', 'a' );
        str = str.replace( 'Ä', 'a' );
        str = str.replace( 'ã', 'a' );
        str = str.replace( 'Ã', 'a' );
        str = str.replace( 'è', 'e' );
        str = str.replace( 'È', 'e' );
        str = str.replace( 'é', 'e' );
        str = str.replace( 'É', 'e' );
        str = str.replace( 'ê', 'e' );
        str = str.replace( 'Ê', 'e' );
        str = str.replace( 'ë', 'e' );
        str = str.replace( 'Ë', 'e' );
        str = str.replace( 'ì', 'i' );
        str = str.replace( 'Ì', 'i' );
        str = str.replace( 'î', 'i' );
        str = str.replace( 'Î', 'i' );
        str = str.replace( 'ï', 'i' );
        str = str.replace( 'Ï', 'i' );
        str = str.replace( 'ò', 'o' );
        str = str.replace( 'Ò', 'o' );
        str = str.replace( 'ô', 'o' );
        str = str.replace( 'Ô', 'o' );
        str = str.replace( 'ö', 'o' );
        str = str.replace( 'Ö', 'o' );
        str = str.replace( 'õ', 'o' );
        str = str.replace( 'Õ', 'o' );
        str = str.replace( 'ù', 'u' );
        str = str.replace( 'Ù', 'u' );
        str = str.replace( 'û', 'u' );
        str = str.replace( 'Û', 'u' );
        str = str.replace( 'ü', 'u' );
        str = str.replace( 'Ü', 'u' );

        // espaces
        str = str.replaceAll( "\\s+", " " );

        // majuscule
        return str.trim().toUpperCase();

    }

    public String asText( JsonNode node ) {
        return node.isMissingNode() ? null : protect( node.asText() );
    }

    public <E extends Enum<E>> E findPMU( Class<E> clazz, String value )
            throws PMUParserError {

        try {
            return PMUEnumFinder.find( clazz, value );
        } catch( PMUFinderException ex ) {
            throw new PMUParserError( "Unknown PMU value", ex );
        }

    }

    public <E extends Enum<E>> E findPMU( Class<E> clazz, JsonNode node )
            throws PMUParserError {
        return node.isMissingNode() ? null : findPMU( clazz, asText( node ) );
    }

    public <E extends Enum<E>> Set<E> findAllPMU( Class<E> clazz, String value )
            throws PMUParserError {

        try {
            return PMUEnumFinder.findAll( clazz, value );
        } catch( PMUFinderException ex ) {
            throw new PMUParserError( "Unknown PMU value", ex );
        }

    }

    public <E extends Enum<E>> Set<E> findAllPMU( Class<E> clazz, JsonNode node )
            throws PMUParserError {
        return node.isMissingNode() ? null : findAllPMU( clazz, asText( node ) );
    }

    public <E, P> void shouldNotBeModified( E entity, P value, P expected ) {

        if( value != null && !Objects.equals( value, expected ) )
            logger.warn( "Unexpected modification of {}: {} -> {}", entity, value, expected );

    }

    public <S extends Set<E>, E> void updateSet(
            Supplier<S> getter,
            Consumer<S> setter,
            S value ) {

        S current = getter.get();
        if( current == null )
            setter.accept( value );

        else {

            for( E elt : new HashSet<>( current ) )
                if( !value.contains( elt ) )
                    current.remove( elt );

            for( E elt : new HashSet<>( value ) )
                if( !current.contains( elt ) )
                    current.add( elt );

        }

    }

}
