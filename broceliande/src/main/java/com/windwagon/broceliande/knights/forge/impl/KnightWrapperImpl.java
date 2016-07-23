package com.windwagon.broceliande.knights.forge.impl;

import com.windwagon.broceliande.knights.entities.FencingMasterRun;
import com.windwagon.broceliande.knights.entities.KnightData;
import com.windwagon.broceliande.knights.entities.RunStatus;
import com.windwagon.broceliande.knights.forge.ActorVisitor;
import com.windwagon.broceliande.knights.forge.Herald;
import com.windwagon.broceliande.knights.forge.KnightWrapper;
import com.windwagon.broceliande.knights.forge.armored.ArmoredKnightWrapper;
import com.windwagon.broceliande.knights.forge.armored.Camp;
import com.windwagon.broceliande.knights.forge.errors.ActorExecutionException;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;
import com.windwagon.kaamelott.Knight;

public class KnightWrapperImpl extends WrappedKnightImpl<ArmoredKnightWrapper, KnightData> implements KnightWrapper {

    private FencingMasterRun fencingMasterRun;

    private String knightName;

    public KnightWrapperImpl( Herald herald, FencingMasterRun fencingMasterRun ) {

        super( herald, fencingMasterRun.getFencingMaster().getKnight() );

        this.fencingMasterRun = fencingMasterRun;

        this.knightName = fencingMasterRun.getFencingMaster().getBrotherhood().getName();

    }

    @Override
    public void actorInitialize( ArmoredKnightWrapper armored ) throws ForgeException {

        Knight knight = armored.getActor();
        knight.initialize();

        if( fencingMasterRun.getStatus() == RunStatus.DONE ) {
            String serialization = fencingMasterRun.getKnightSerialization();
            if( serialization != null ) {

                byte[] bytes = base64decode( serialization );

                try {
                    knight.unmarshal( bytes );
                } catch( Throwable ex ) {
                    throw new ActorExecutionException( ex );
                }

            }
        }

    }

    @Override
    public String getName() {
        return knightName;
    }

    @Override
    protected ArmoredKnightWrapper createArmor( Camp camp ) {
        return camp.getKnight( this );
    }

    @Override
    public <R> R accept( ActorVisitor<R> visitor ) {
        return visitor.visitKnight( this );
    }

}
