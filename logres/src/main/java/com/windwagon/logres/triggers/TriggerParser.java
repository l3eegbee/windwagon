package com.windwagon.logres.triggers;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TriggerParser {

    @Autowired
    private TriggerFactory triggerFactory;

    public FixRateTrigger parse( String trigger ) {
        return TriggersParser.getParser( trigger, triggerFactory ).trigger().trig;
    }

    public OffsetTrigger createOffsetTrigger( Collection<Offset> offsets ) {
        OffsetTrigger offsetTriger = triggerFactory.getOffsetTrigger();
        offsetTriger.setOffsets( offsets );
        return offsetTriger;
    }

    public OffsetTrigger createOffsetTrigger( Offset ... offsets ) {
        return createOffsetTrigger( Arrays.asList( offsets ) );
    }

    public OffsetTrigger createOffsetTrigger( String offsets ) {
        return createOffsetTrigger(
                TriggersParser.getParser( offsets, triggerFactory ).offsets().offs );
    }

}
