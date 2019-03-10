package com.windwagon.logres.date;



import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class LazyDate {

    public static final DateTimeFormatter FORMAT_Y = DateTimeFormatter.ofPattern( "yyyy" );

    public static final DateTimeFormatter FORMAT_M = DateTimeFormatter.ofPattern( "MM-yyyy" );

    public static final DateTimeFormatter FORMAT_D = DateTimeFormatter.ofPattern( "dd-MM-yyyy" );

    public static final DateTimeFormatter FORMAT_H = DateTimeFormatter.ofPattern( "dd-MM-yyyy HH:mm" );

    public static final DateTimeFormatter FORMAT_S = DateTimeFormatter.ofPattern( "dd-MM-yyyy HH:mm:ss" );

    public static LazyDate Y( Date date ) {
        return new LazyDate( date, FORMAT_Y );
    }

    public static LazyDate Y( LocalDate date ) {
        return new LazyDate( date, FORMAT_Y );
    }

    public static LazyDate M( Date date ) {
        return new LazyDate( date, FORMAT_M );
    }

    public static LazyDate M( LocalDate date ) {
        return new LazyDate( date, FORMAT_M );
    }

    public static LazyDate D( Date date ) {
        return new LazyDate( date, FORMAT_D );
    }

    public static LazyDate D( LocalDate date ) {
        return new LazyDate( date, FORMAT_D );
    }

    public static LazyDate H( Date date ) {
        return new LazyDate( date, FORMAT_H );
    }

    public static LazyDate H( LocalDate date ) {
        return new LazyDate( date, FORMAT_H );
    }

    public static LazyDate S( Date date ) {
        return new LazyDate( date, FORMAT_S );
    }

    public static LazyDate S( LocalDate date ) {
        return new LazyDate( date, FORMAT_S );
    }

    private ZonedDateTime date = null;

    private DateTimeFormatter dateFormat;

    public LazyDate( ZonedDateTime date, DateTimeFormatter dateFormat ) {
        this.date = date;
        this.dateFormat = dateFormat;
    }

    public LazyDate( LocalDate date, DateTimeFormatter dateFormat ) {
        this( DateConverter.toZonedDateTime( date ), dateFormat );
    }

    public LazyDate( Date date, DateTimeFormatter dateFormat ) {
        this( DateConverter.toZonedDateTime( date ), dateFormat );
    }

    public String toString() {
        return date == null ? "null" : date.format( dateFormat );
    }

}
