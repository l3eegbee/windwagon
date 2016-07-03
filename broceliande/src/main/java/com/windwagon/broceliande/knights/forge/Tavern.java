package com.windwagon.broceliande.knights.forge;

import java.util.regex.Matcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.windwagon.broceliande.knights.entities.BrotherhoodRun;
import com.windwagon.broceliande.knights.entities.ComponentData;
import com.windwagon.broceliande.knights.entities.Cycle;
import com.windwagon.broceliande.knights.entities.FencingMasterRun;
import com.windwagon.broceliande.knights.entities.OfficialKnightData;
import com.windwagon.broceliande.knights.entities.PageData;
import com.windwagon.broceliande.knights.entities.ScribeRun;
import com.windwagon.broceliande.knights.forge.ComponentPatterns.BrotherhoodElements;
import com.windwagon.broceliande.knights.forge.ComponentPatterns.ComponentElements;
import com.windwagon.broceliande.knights.forge.ComponentPatterns.FencingMasterElements;
import com.windwagon.broceliande.knights.forge.ComponentPatterns.OfficialComponentElements;
import com.windwagon.broceliande.knights.forge.ComponentPatterns.OfficialKnightElements;
import com.windwagon.broceliande.knights.forge.ComponentPatterns.PageElements;
import com.windwagon.broceliande.knights.forge.ComponentPatterns.ScribeElements;
import com.windwagon.broceliande.knights.forge.ComponentPatterns.SelectedKnightElements;
import com.windwagon.broceliande.knights.forge.ComponentPatterns.TrainedKnightElements;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;
import com.windwagon.broceliande.knights.repositories.BrotherhoodRunRepository;
import com.windwagon.broceliande.knights.repositories.ComponentDataRepository;
import com.windwagon.broceliande.knights.repositories.FencingMasterRunRepository;
import com.windwagon.broceliande.knights.repositories.OfficialKnightDataRepository;
import com.windwagon.broceliande.knights.repositories.PageDataRepository;
import com.windwagon.broceliande.knights.repositories.ScribeRunRepository;

@Component
public class Tavern {

    @Autowired
    private Casern casern;

    @Autowired
    private OfficialKnightDataRepository officialKnightDataRepository;

    @Autowired
    private FencingMasterRunRepository fencingMasterRunRepository;

    @Autowired
    private BrotherhoodRunRepository brotherhoodRunRepository;

    @Autowired
    private ScribeRunRepository scribeRunRepository;

    @Autowired
    private PageDataRepository pageDataRepository;

    @Autowired
    private ComponentDataRepository componentDataRepository;

    public ComponentWrapper findComponent( String completeName ) throws ForgeException {
        return findComponent( completeName, null );
    }

    public ComponentWrapper findComponent( String completeName, Cycle cycle ) throws ForgeException {

        if( completeName == null || completeName.isEmpty() )
            throw new ForgeException( "Empty component name." );

        try {

            Matcher officialKnightMatcher = ComponentPatterns.OFFICIAL_KNIGHT_PATTERN.matcher( completeName );
            if( officialKnightMatcher.matches() )
                return getOfficialKnight( officialKnightMatcher );

            Matcher trainedKnightMatcher = ComponentPatterns.TRAINED_KNIGHT_PATTERN.matcher( completeName );
            if( trainedKnightMatcher.matches() )
                return getTrainedKnight( cycle, trainedKnightMatcher );

            Matcher selectedKnightMatcher = ComponentPatterns.SELECTED_KNIGHT_PATTERN.matcher( completeName );
            if( selectedKnightMatcher.matches() )
                return getSelectedKnight( cycle, selectedKnightMatcher );

            Matcher fencingMasterMatcher = ComponentPatterns.FENCING_MASTER_PATTERN.matcher( completeName );
            if( fencingMasterMatcher.matches() )
                return getFencingMaster( cycle, fencingMasterMatcher );

            Matcher brotherhoodMatcher = ComponentPatterns.BROTHERHOOD_PATTERN.matcher( completeName );
            if( brotherhoodMatcher.matches() )
                return getBrotherhood( cycle, brotherhoodMatcher );

            Matcher scribeMatcher = ComponentPatterns.SCRIBE_PATTERN.matcher( completeName );
            if( scribeMatcher.matches() )
                return getScribe( cycle, scribeMatcher );

            Matcher pageMatcher = ComponentPatterns.PAGE_PATTERN.matcher( completeName );
            if( pageMatcher.matches() )
                return getPage( cycle, pageMatcher );

            Matcher officialComponentMatcher = ComponentPatterns.OFFICIAL_COMPONENT_PATTERN.matcher( completeName );
            if( officialComponentMatcher.matches() )
                return getOfficialComponent( officialComponentMatcher );

            Matcher componentMatcher = ComponentPatterns.COMPONENT_PATTERN.matcher( completeName );
            if( componentMatcher.matches() )
                return getComponent( componentMatcher );

        } catch( ForgeException ex ) {
            throw new ForgeException( "Exception during getting component [" + completeName + "]" );
        }

        throw new ForgeException( "No component match syntax [" + completeName + "]" );

    }

    public OfficialKnightWrapper getOfficialKnight( Matcher matcher ) throws ForgeException {
        OfficialKnightElements elts = ComponentPatterns.getOfficialKnightElements( matcher );
        return getOfficialKnight( elts.getKnightName(), elts.getOfficialId() );
    }

    public OfficialKnightWrapper getOfficialKnight( String kname, String offid ) throws ForgeException {

        OfficialKnightData knightData =
                officialKnightDataRepository.findByNameAndComponentComponentClassOfficialId( kname, offid );

        if( knightData == null )
            throw new ForgeException( "Official knight [" + kname + "][" + offid + "] not found" );

        return casern.getOfficialKnight( knightData );

    }

    public KnightWrapper getTrainedKnight( Cycle cycle, Matcher matcher ) throws ForgeException {
        TrainedKnightElements elts = ComponentPatterns.getTrainedKnightElements( matcher );
        return getTrainedKnight( cycle, elts.getKnightName(), elts.getFencingMasterName() );
    }

    public KnightWrapper getTrainedKnight( Cycle cycle, String kname, String fmname ) throws ForgeException {

        if( cycle == null )
            throw new ForgeException( "Cycle must be defined." );

        FencingMasterRun fencingMasterRun =
                fencingMasterRunRepository
                        .findByCycleAndFencingMasterBrotherhoodNameAndFencingMasterName( cycle, kname, fmname );

        if( fencingMasterRun == null )
            throw new ForgeException( "Trained knight [" + kname + "][" + fmname + "] not found" );

        return casern.getKnight( fencingMasterRun );

    }

    public KnightWrapper getSelectedKnight( Cycle cycle, Matcher matcher ) throws ForgeException {
        SelectedKnightElements elts = ComponentPatterns.getSelectedKnightElements( matcher );
        return getSelectedKnight( cycle, elts.getKnightName() );
    }

    public KnightWrapper getSelectedKnight( Cycle cycle, String kname ) throws ForgeException {

        if( cycle == null )
            throw new ForgeException( "Cycle must be defined." );

        BrotherhoodRun brotherhoodRun = brotherhoodRunRepository.findByCycleAndBrotherhoodName( cycle, kname );

        if( brotherhoodRun == null )
            throw new ForgeException( "Selected knight [" + kname + "] not found" );

        return casern.getKnight( brotherhoodRun.getSelected() );

    }

    public FencingMasterWrapper getFencingMaster( Cycle cycle, Matcher matcher ) throws ForgeException {
        FencingMasterElements elts = ComponentPatterns.getFencingMasterElements( matcher );
        return getFencingMaster( cycle, elts.getKnightName(), elts.getFencingMasterName() );
    }

    public FencingMasterWrapper getFencingMaster( Cycle cycle, String kname, String fmname ) throws ForgeException {

        if( cycle == null )
            throw new ForgeException( "Cycle must be defined." );

        FencingMasterRun fencingMasterRun =
                fencingMasterRunRepository
                        .findByCycleAndFencingMasterBrotherhoodNameAndFencingMasterName( cycle, kname, fmname );

        if( fencingMasterRun == null )
            throw new ForgeException( "Fencing master [" + kname + "][" + fmname + "] not found" );

        return casern.getFencingMaster( fencingMasterRun );

    }

    public BrotherhoodWrapper getBrotherhood( Cycle cycle, Matcher matcher ) throws ForgeException {
        BrotherhoodElements elts = ComponentPatterns.getBrotherhoodElements( matcher );
        return getBrotherhood( cycle, elts.getName() );
    }

    public BrotherhoodWrapper getBrotherhood( Cycle cycle, String kname ) throws ForgeException {

        if( cycle == null )
            throw new ForgeException( "Cycle must be defined." );

        BrotherhoodRun brotherhoodRun = brotherhoodRunRepository.findByCycleAndBrotherhoodName( cycle, kname );

        if( brotherhoodRun == null )
            throw new ForgeException( "Brotherhood [" + kname + "] not found" );

        return casern.getBrotherhood( brotherhoodRun );

    }

    public ScribeWrapper getScribe( Cycle cycle, Matcher matcher ) throws ForgeException {
        ScribeElements elts = ComponentPatterns.getScribeElements( matcher );
        return getScribe( cycle, elts.getName() );
    }

    public ScribeWrapper getScribe( Cycle cycle, String sname ) throws ForgeException {

        if( cycle == null )
            throw new ForgeException( "Cycle must be defined." );

        ScribeRun scribeRun = scribeRunRepository.findByCycleAndScribeName( cycle, sname );

        if( scribeRun == null )
            throw new ForgeException( "Scribe [" + sname + "] not found" );

        return casern.getScribe( scribeRun );

    }

    public PageWrapper getPage( Cycle cycle, Matcher matcher ) throws ForgeException {
        PageElements elts = ComponentPatterns.getPageElements( matcher );
        return getPage( cycle, elts.getName() );
    }

    public PageWrapper getPage( Cycle cycle, String pname ) throws ForgeException {

        if( cycle == null )
            throw new ForgeException( "Cycle must be defined." );

        PageData pageData = pageDataRepository.findByName( pname );

        if( pageData == null )
            throw new ForgeException( "Page [" + pname + "] not found" );

        return casern.getPage( cycle, pageData );

    }

    public ComponentWrapper getOfficialComponent( Matcher matcher ) throws ForgeException {
        OfficialComponentElements elts = ComponentPatterns.getOfficialComponentElements( matcher );
        return getOfficialComponent( elts.getName(), elts.getOfficialId() );
    }

    public ComponentWrapper getOfficialComponent( String cname, String offid ) throws ForgeException {

        ComponentData component = componentDataRepository.findByNameAndComponentClassOfficialId( cname, offid );

        if( component == null )
            throw new ForgeException( "Official component [" + cname + "][" + offid + "] not found" );

        return casern.getComponent( component );

    }

    public ComponentWrapper getComponent( Matcher matcher ) throws ForgeException {
        ComponentElements elts = ComponentPatterns.getComponentElements( matcher );
        return getComponent( elts.getName() );
    }

    public ComponentWrapper getComponent( String cname ) throws ForgeException {

        ComponentData component = componentDataRepository.findByName( cname );

        if( component == null )
            throw new ForgeException( "Component [" + cname + "] not found" );

        return casern.getComponent( component );

    }

}
