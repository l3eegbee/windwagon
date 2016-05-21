
grammar Triggers;

@parser::header {

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

}

@parser::members {

    public static TriggersParser getParser( String str, TriggerFactory triggerFactory ) {

        ANTLRInputStream input = new ANTLRInputStream( str );
        TriggersLexer lexer = new TriggersLexer( input );
        CommonTokenStream tokens = new CommonTokenStream( lexer );
        TriggersParser parser = new TriggersParser( tokens );
        parser.setTriggerFactory( triggerFactory );
        parser.setBuildParseTree( false );

        return parser;

    }

    private TriggerFactory triggerFactory;

    public void setTriggerFactory( TriggerFactory triggerFactory ) {
        this.triggerFactory = triggerFactory;
    }

}

trigger returns [FixRateTrigger trig]
    : 'monthly:' day ':' hour
        { $trig = triggerFactory.getMonthlyTrigger( $day.value, $hour.localTime ); }
    | 'weekly:' name_day ':' hour
        { $trig = triggerFactory.getWeeklyTrigger( $name_day.dow, $hour.localTime ); }
    | 'daily:' hour
        { $trig = triggerFactory.getDailyTrigger( $hour.localTime ); }
    ;

day returns [int value]: integer { $value = $integer.value; } ;

name_day returns [DayOfWeek dow]
    : 'mon' { $dow = DayOfWeek.MONDAY; }
    | 'tue' { $dow = DayOfWeek.TUESDAY; }
    | 'wed' { $dow = DayOfWeek.WEDNESDAY; }
    | 'thu' { $dow = DayOfWeek.THURSDAY; }
    | 'fri' { $dow = DayOfWeek.FRIDAY; }
    | 'sat' { $dow = DayOfWeek.SATURDAY; }
    | 'sun' { $dow = DayOfWeek.SUNDAY; }
    ;

hour returns [LocalTime localTime]
    : h 'h' m { $localTime = LocalTime.of( $h.value, $m.value ); } ;

h returns [int value]: integer { $value = $integer.value; } ;
m returns [int value]: integer { $value = $integer.value; } ;

offsets returns [List<Offset> offs]
@init{ $offs = new LinkedList<Offset>(); }
    : offset { $offs.add( $offset.off ); } ( ',' offset { $offs.add( $offset.off ); } )* ;

offset returns [Offset off]
    : v=integer u=temporal_unit r=STAR? {
        Duration duration = Duration.of( $v.value, $u.unit );
        $off = triggerFactory.getOffset( duration, $r != null ); }
    ;

temporal_unit returns [TemporalUnit unit]
    : 'h' { $unit = ChronoUnit.HOURS; }
    | 'm' { $unit = ChronoUnit.MINUTES; }
    | 's' { $unit = ChronoUnit.SECONDS; }
    ;

integer returns [int value]
    : INTEGER { $value = Integer.valueOf( $INTEGER.getText() ); }
    ;

WHITESPACE : [ \t\f] -> skip ;
INTEGER : [+-]? [0-9]+ ;
STAR : [*] ;
ALPHANUM : [a-zA-Z:,;] ;

