package com.windwagon.logres.date;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class DateConverter {

    private DateConverter() {}

    /*
     * Convert to Date
     */

    public static Date toDate( ZonedDateTime zonedDateTime ) {
        return zonedDateTime == null ? null : Date.from( zonedDateTime.toInstant() );
    }

    public static Date toDate( Instant instant ) {
        return instant == null ? null : Date.from( instant );
    }

    public static Date toDate( LocalDate localDate ) {
        return localDate == null ? null : toDate( toZonedDateTime( localDate ) );
    }

    public static Date toDate( LocalDateTime localDateTime ) {
        return localDateTime == null ? null : toDate( toZonedDateTime( localDateTime ) );
    }

    /*
     * Convert to ZonedDateTime
     */

    public static ZonedDateTime toZonedDateTime( Date date ) {
        return date == null ? null : toZonedDateTime( new Date( date.getTime() ).toInstant() );
    }

    public static ZonedDateTime toZonedDateTime( Instant instant ) {
        return instant == null ? null : instant.atZone( ZoneId.systemDefault() );
    }

    public static ZonedDateTime toZonedDateTime( LocalDateTime localDateTime ) {
        return localDateTime == null ? null : localDateTime.atZone( ZoneId.systemDefault() );
    }

    public static ZonedDateTime toZonedDateTime( LocalDate localDate ) {
        return localDate == null ? null : localDate.atStartOfDay( ZoneId.systemDefault() );
    }

    /*
     * Convert to LocalDate
     */

    public static LocalDate toLocalDate( ZonedDateTime zonedDateTime ) {
        return zonedDateTime == null ? null : zonedDateTime.toLocalDate();
    }

    public static LocalDate toLocalDate( Date date ) {
        return date == null ? null : toLocalDate( toZonedDateTime( date ) );
    }

    public static LocalDate toLocalDate( Instant instant ) {
        return instant == null ? null : toLocalDate( toZonedDateTime( instant ) );
    }

    public static LocalDate toLocalDate( LocalDateTime localDateTime ) {
        return localDateTime == null ? null : localDateTime.toLocalDate();
    }

    /*
     * Start of the year
     */

    public static LocalDate startOfTheYear( ZonedDateTime zonedDateTime ) {
        return zonedDateTime == null ? null : toLocalDate( zonedDateTime.with( TemporalAdjusters.firstDayOfYear() ) );
    }

    public static LocalDate startOfTheYear( Date date ) {
        return date == null ? null : startOfTheYear( toZonedDateTime( date ) );
    }

    public static LocalDate startOfTheYear( Instant instant ) {
        return instant == null ? null : startOfTheYear( toZonedDateTime( instant ) );
    }

    public static LocalDate startOfTheYear( LocalDateTime localDateTime ) {
        return localDateTime == null ? null : startOfTheYear( toZonedDateTime( localDateTime ) );
    }

}
