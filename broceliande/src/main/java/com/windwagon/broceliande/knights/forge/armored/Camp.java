package com.windwagon.broceliande.knights.forge.armored;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.windwagon.broceliande.knights.entities.Cycle;
import com.windwagon.broceliande.knights.forge.BrotherhoodWrapper;
import com.windwagon.broceliande.knights.forge.FencingMasterWrapper;
import com.windwagon.broceliande.knights.forge.KnightWrapper;
import com.windwagon.broceliande.knights.forge.OfficialKnightWrapper;
import com.windwagon.broceliande.knights.forge.PageWrapper;
import com.windwagon.broceliande.knights.forge.ScribeWrapper;

public class Camp {

    @Autowired
    private Armory armory;

    private Cycle cycle;

    private Map<KnightWrapper, ArmoredKnightWrapper> knights = new HashMap<>();

    private Map<OfficialKnightWrapper, ArmoredOfficialKnightWrapper> officialKnights = new HashMap<>();

    private Map<FencingMasterWrapper, ArmoredFencingMasterWrapper> fencingMasters = new HashMap<>();

    private Map<BrotherhoodWrapper, ArmoredBrotherhoodWrapper> brotherhoods = new HashMap<>();

    private Map<ScribeWrapper, ArmoredScribeWrapper> scribes = new HashMap<>();

    private Map<PageWrapper, ArmoredPageWrapper> pages = new HashMap<>();

    public Camp( Cycle cycle ) {
        this.cycle = cycle;
    }

    public Cycle getCycle() {
        return cycle;
    }

    public ArmoredKnightWrapper getKnight( KnightWrapper wrapper ) {
        return knights.computeIfAbsent( wrapper, data -> armory.getArmoredKnight( this, wrapper ) );
    }

    public ArmoredOfficialKnightWrapper getOfficialKnight( OfficialKnightWrapper wrapper ) {
        return officialKnights.computeIfAbsent( wrapper, data -> armory.getArmoredOfficialKnight( this, wrapper ) );
    }

    public ArmoredFencingMasterWrapper getFencingMaster( FencingMasterWrapper wrapper ) {
        return fencingMasters.computeIfAbsent( wrapper, data -> armory.getArmoredFencingMaster( this, wrapper ) );
    }

    public ArmoredBrotherhoodWrapper getBrotherhood( BrotherhoodWrapper wrapper ) {
        return brotherhoods.computeIfAbsent( wrapper, data -> armory.getArmoredBrotherhood( this, wrapper ) );
    }

    public ArmoredScribeWrapper getScribe( ScribeWrapper wrapper ) {
        return scribes.computeIfAbsent( wrapper, data -> armory.getArmoredScribe( this, wrapper ) );
    }

    public ArmoredPageWrapper getPage( PageWrapper wrapper ) {
        return pages.computeIfAbsent( wrapper, data -> armory.getArmoredPage( this, wrapper ) );
    }

}
