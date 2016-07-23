package com.windwagon.broceliande.knights.forge.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.windwagon.broceliande.knights.entities.OfficialKnightData;
import com.windwagon.broceliande.knights.forge.ActorVisitor;
import com.windwagon.broceliande.knights.forge.Herald;
import com.windwagon.broceliande.knights.forge.OfficialKnightWrapper;
import com.windwagon.broceliande.knights.forge.armored.ArmoredOfficialKnightWrapper;
import com.windwagon.broceliande.knights.forge.armored.Camp;
import com.windwagon.broceliande.knights.forge.errors.ActorExecutionException;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;
import com.windwagon.broceliande.race.entities.Race;
import com.windwagon.broceliande.race.turf.RaceWrapper;
import com.windwagon.broceliande.race.turf.Stud;
import com.windwagon.kaamelott.Knight;
import com.windwagon.kaamelott.words.Words;

public class OfficialKnightWrapperImpl extends WrappedKnightImpl<ArmoredOfficialKnightWrapper, OfficialKnightData>
        implements OfficialKnightWrapper {

    @Autowired
    private Stud stud;

    public OfficialKnightWrapperImpl( Herald herald, OfficialKnightData officialKnightData ) {
        super( herald, officialKnightData );
    }

    @Override
    public Words getWords( Race race ) throws ForgeException {

        RaceWrapper raceWrapper = stud.getRace( race );

        return call( armored -> {
            return armored.getActor().getWords( raceWrapper );
        } );

    }

    @Override
    public void actorInitialize( ArmoredOfficialKnightWrapper armored ) throws ForgeException {

        Knight knight = armored.getActor();
        knight.initialize();

        String serialization = actorData.getSerialization();
        if( serialization != null ) {

            byte[] bytes = base64decode( serialization );

            try {
                knight.unmarshal( bytes );
            } catch( Throwable ex ) {
                throw new ActorExecutionException( ex );
            }

        }

    }

    @Override
    protected ArmoredOfficialKnightWrapper createArmor( Camp camp ) {
        return camp.getOfficialKnight( this );
    }

    @Override
    public <R> R accept( ActorVisitor<R> visitor ) {
        return visitor.visitOfficialKnight( this );
    }

}
