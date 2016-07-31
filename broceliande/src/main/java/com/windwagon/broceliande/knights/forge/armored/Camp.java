package com.windwagon.broceliande.knights.forge.armored;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.windwagon.broceliande.knights.entities.Cycle;
import com.windwagon.broceliande.knights.forge.BrotherhoodWrapper;
import com.windwagon.broceliande.knights.forge.FencingMasterWrapper;
import com.windwagon.broceliande.knights.forge.Herald;
import com.windwagon.broceliande.knights.forge.KnightWrapper;
import com.windwagon.broceliande.knights.forge.OfficialKnightWrapper;
import com.windwagon.broceliande.knights.forge.PageWrapper;
import com.windwagon.broceliande.knights.forge.ScribeWrapper;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;

public class Camp {

    @Autowired
    private Armory armory;

    private Cycle cycle;

    private Herald herald;

    private Map<KnightWrapper, ArmoredKnightWrapper> knights = new HashMap<>();

    private Map<OfficialKnightWrapper, ArmoredOfficialKnightWrapper> officialKnights = new HashMap<>();

    private Map<FencingMasterWrapper, ArmoredFencingMasterWrapper> fencingMasters = new HashMap<>();

    private Map<BrotherhoodWrapper, ArmoredBrotherhoodWrapper> brotherhoods = new HashMap<>();

    private Map<ScribeWrapper, ArmoredScribeWrapper> scribes = new HashMap<>();

    private Map<PageWrapper, ArmoredPageWrapper> pages = new HashMap<>();

    public Camp( Cycle cycle, Herald herald ) {
        this.cycle = cycle;
        this.herald = herald;
    }

    public Cycle getCycle() {
        return cycle;
    }

    public Herald getHerald() {
        return this.herald;
    }

    private interface ArmoredMaker<A> {

        public A create() throws ForgeException;

    }

    private <W, A extends ArmoredActorWrapper<?>> A get( Map<W, A> map, W wrapper, ArmoredMaker<A> maker )
            throws ForgeException {

        if( !map.containsKey( wrapper ) ) {
            A armored = maker.create();
            map.put( wrapper, armored );
            armored.initialize();
            return armored;
        } else
            return map.get( wrapper );

    }

    public ArmoredKnightWrapper getKnight( KnightWrapper wrapper ) throws ForgeException {
        return get( knights, wrapper, () -> armory.getArmoredKnight( this, wrapper ) );
    }

    public ArmoredOfficialKnightWrapper getOfficialKnight( OfficialKnightWrapper wrapper ) throws ForgeException {
        return get( officialKnights, wrapper, () -> armory.getArmoredOfficialKnight( this, wrapper ) );
    }

    public ArmoredFencingMasterWrapper getFencingMaster( FencingMasterWrapper wrapper ) throws ForgeException {
        return get( fencingMasters, wrapper, () -> armory.getArmoredFencingMaster( this, wrapper ) );
    }

    public ArmoredBrotherhoodWrapper getBrotherhood( BrotherhoodWrapper wrapper ) throws ForgeException {
        return get( brotherhoods, wrapper, () -> armory.getArmoredBrotherhood( this, wrapper ) );
    }

    public ArmoredScribeWrapper getScribe( ScribeWrapper wrapper ) throws ForgeException {
        return get( scribes, wrapper, () -> armory.getArmoredScribe( this, wrapper ) );
    }

    public ArmoredPageWrapper getPage( PageWrapper wrapper ) throws ForgeException {
        return get( pages, wrapper, () -> armory.getArmoredPage( this, wrapper ) );
    }

}
