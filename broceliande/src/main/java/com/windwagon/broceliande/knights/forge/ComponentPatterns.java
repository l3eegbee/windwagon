package com.windwagon.broceliande.knights.forge;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.windwagon.broceliande.knights.entities.BrotherhoodData;
import com.windwagon.broceliande.knights.entities.BrotherhoodRun;
import com.windwagon.broceliande.knights.entities.ComponentData;
import com.windwagon.broceliande.knights.entities.FencingMasterData;
import com.windwagon.broceliande.knights.entities.FencingMasterRun;
import com.windwagon.broceliande.knights.entities.OfficialKnightData;
import com.windwagon.broceliande.knights.entities.PageData;
import com.windwagon.broceliande.knights.entities.ScribeData;
import com.windwagon.broceliande.knights.entities.ScribeRun;

public class ComponentPatterns {

    public static final String CYCLE_SEPARATOR = "%";

    /*
     * OFFICIAL KNIGHT
     */

    public static final Pattern OFFICIAL_KNIGHT_PATTERN = Pattern.compile( "^kn:(?<kname>[^@]*)@(?<offid>.*)$" );

    public static Matcher officialKnightMatcher( String name ) {
        return OFFICIAL_KNIGHT_PATTERN.matcher( name );
    }

    public static class OfficialKnightElements {

        private String knightName;

        private String officialId;

        public OfficialKnightElements( String knightName, String officialId ) {
            this.knightName = knightName;
            this.officialId = officialId;
        }

        public String getKnightName() {
            return this.knightName;
        }

        public String getOfficialId() {
            return this.officialId;
        }

    }

    public static OfficialKnightElements getOfficialKnightElements( Matcher matcher ) {
        return new OfficialKnightElements( matcher.group( "kname" ), matcher.group( "offid" ) );
    }

    public static String getOfficialKnightName( OfficialKnightData data ) {
        return "kn:" + data.getName() + "@" + data.getComponent().getComponentClass().getOfficialId();
    }

    public static String getOfficialKnightName( OfficialKnightWrapper wrapper ) {
        return getOfficialKnightName( wrapper.getActorData() );
    }

    /*
     * TRAINED KNIGHT
     */

    public static final Pattern TRAINED_KNIGHT_PATTERN = Pattern.compile( "^kn:(?<kname>[^$]*)\\$(?<fmname>.*)$" );

    public static Matcher trainedKnightMatcher( String name ) {
        return TRAINED_KNIGHT_PATTERN.matcher( name );
    }

    public static class TrainedKnightElements {

        private String knightName;

        private String fencingMasterName;

        public TrainedKnightElements( String knightName, String fencingMasterName ) {
            this.knightName = knightName;
            this.fencingMasterName = fencingMasterName;
        }

        public String getKnightName() {
            return this.knightName;
        }

        public String getFencingMasterName() {
            return this.fencingMasterName;
        }

    }

    public static TrainedKnightElements getTrainedKnightElements( Matcher matcher ) {
        return new TrainedKnightElements( matcher.group( "kname" ), matcher.group( "fmname" ) );
    }

    public static String getTrainedKnightName( FencingMasterData data ) {
        return "kn:" + data.getBrotherhood().getName() + "$" + data.getName();
    }

    public static String getTrainedKnightName( FencingMasterWrapper wrapper ) {
        return getTrainedKnightName( wrapper.getActorData() );
    }

    public static String getTrainedKnightName( FencingMasterRun run ) {
        return getTrainedKnightName( run.getFencingMaster() );
    }

    /*
     * SELECTED KNIGHT
     */

    public static final Pattern SELECTED_KNIGHT_PATTERN = Pattern.compile( "^kn:(?<kname>.*)$" );

    public static Matcher selectedKnightMatcher( String name ) {
        return SELECTED_KNIGHT_PATTERN.matcher( name );
    }

    public static class SelectedKnightElements {

        private String knightName;

        public SelectedKnightElements( String knightName ) {
            this.knightName = knightName;
        }

        public String getKnightName() {
            return this.knightName;
        }

    }

    public static SelectedKnightElements getSelectedKnightElements( Matcher matcher ) {
        return new SelectedKnightElements( matcher.group( "kname" ) );
    }

    public static String getSelectedKnightName( BrotherhoodData data ) {
        return "kn:" + data.getName();
    }

    public static String getSelectedKnightName( BrotherhoodWrapper wrapper ) {
        return getSelectedKnightName( wrapper.getActorData() );
    }

    public static String getSelectedKnightName( BrotherhoodRun run ) {
        return getSelectedKnightName( run.getBrotherhood() );
    }

    /*
     * FENCING MASTER
     */

    public static final Pattern FENCING_MASTER_PATTERN = Pattern.compile( "^fm:(?<kname>[^$]*)\\$(?<fmname>.*)$" );

    public static Matcher fencingMasterMatcher( String name ) {
        return FENCING_MASTER_PATTERN.matcher( name );
    }

    public static class FencingMasterElements {

        private String knightName;

        private String fencingMasterName;

        public FencingMasterElements( String knightName, String fencingMasterName ) {
            this.knightName = knightName;
            this.fencingMasterName = fencingMasterName;
        }

        public String getKnightName() {
            return this.knightName;
        }

        public String getFencingMasterName() {
            return this.fencingMasterName;
        }

    }

    public static FencingMasterElements getFencingMasterElements( Matcher matcher ) {
        return new FencingMasterElements( matcher.group( "kname" ), matcher.group( "fmname" ) );
    }

    public static String getFencingMasterName( FencingMasterData data ) {
        return "fm:" + data.getBrotherhood().getName() + "$" + data.getName();
    }

    public static String getFencingMasterName( FencingMasterWrapper wrapper ) {
        return getFencingMasterName( wrapper.getActorData() );
    }

    public static String getFencingMasterName( FencingMasterRun run ) {
        return getFencingMasterName( run.getFencingMaster() );
    }

    /*
     * BROTHERHOOD
     */

    public static final Pattern BROTHERHOOD_PATTERN = Pattern.compile( "^bh:(?<kname>.*)$" );

    public static Matcher brotherhoodMatcher( String name ) {
        return BROTHERHOOD_PATTERN.matcher( name );
    }

    public static class BrotherhoodElements {

        private String name;

        public BrotherhoodElements( String name ) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

    }

    public static BrotherhoodElements getBrotherhoodElements( Matcher matcher ) {
        return new BrotherhoodElements( matcher.group( "kname" ) );
    }

    public static String getBrotherhoodName( BrotherhoodData data ) {
        return "bh:" + data.getName();
    }

    public static String getBrotherhoodName( BrotherhoodWrapper wrapper ) {
        return getBrotherhoodName( wrapper.getActorData() );
    }

    public static String getBrotherhoodName( BrotherhoodRun run ) {
        return getBrotherhoodName( run.getBrotherhood() );
    }

    /*
     * SCRIBE
     */

    public static final Pattern SCRIBE_PATTERN = Pattern.compile( "^sb:(?<sname>.*)$" );

    public static Matcher scribeMatcher( String name ) {
        return SCRIBE_PATTERN.matcher( name );
    }

    public static class ScribeElements {

        private String name;

        public ScribeElements( String name ) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

    }

    public static ScribeElements getScribeElements( Matcher matcher ) {
        return new ScribeElements( matcher.group( "sname" ) );
    }

    public static String getScribeName( ScribeData data ) {
        return "sb:" + data.getName();
    }

    public static String getScribeName( ScribeWrapper wrapper ) {
        return getScribeName( wrapper.getActorData() );
    }

    public static String getScribeName( ScribeRun run ) {
        return getScribeName( run.getScribe() );
    }

    /*
     * PAGE
     */

    public static final Pattern PAGE_PATTERN = Pattern.compile( "^pg:(?<pname>.*)$" );

    public static Matcher pageMatcher( String name ) {
        return PAGE_PATTERN.matcher( name );
    }

    public static class PageElements {

        private String name;

        public PageElements( String name ) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

    }

    public static PageElements getPageElements( Matcher matcher ) {
        return new PageElements( matcher.group( "pname" ) );
    }

    public static String getPageName( PageData data ) {
        return "pg:" + data.getName();
    }

    public static String getPageName( PageWrapper wrapper ) {
        return getPageName( wrapper.getActorData() );
    }

    /*
     * OFFICIAL COMPONENT
     */

    public static final Pattern OFFICIAL_COMPONENT_PATTERN = Pattern.compile( "^(?<cname>[^@]*)@(?<offid>.*)$" );

    public static Matcher officalComponentMatcher( String name ) {
        return OFFICIAL_COMPONENT_PATTERN.matcher( name );
    }

    public static class OfficialComponentElements {

        private String name;

        private String officialId;

        public OfficialComponentElements( String name, String officialId ) {
            this.name = name;
            this.officialId = officialId;
        }

        public String getName() {
            return this.name;
        }

        public String getOfficialId() {
            return this.officialId;
        }

    }

    public static OfficialComponentElements getOfficialComponentElements( Matcher matcher ) {
        return new OfficialComponentElements( matcher.group( "cname" ), matcher.group( "offid" ) );
    }

    /*
     * COMPONENT
     */

    public static final Pattern COMPONENT_PATTERN = Pattern.compile( "^(?<cname>.*)$" );

    public static Matcher componentMatcher( String name ) {
        return COMPONENT_PATTERN.matcher( name );
    }

    public static class ComponentElements {

        private String name;

        public ComponentElements( String name ) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

    }

    public static ComponentElements getComponentElements( Matcher matcher ) {
        return new ComponentElements( matcher.group( "cname" ) );
    }

    public static String getComponentName( ComponentData data ) {
        String name = data.getName();
        String offid = data.getComponentClass().getOfficialId();
        if( offid != null )
            name = name + "@" + offid;
        return name;
    }

    /*
     * OTHERS
     */

    public static boolean isActor( String name ) {

        return officialKnightMatcher( name ).matches()
                || selectedKnightMatcher( name ).matches()
                || fencingMasterMatcher( name ).matches()
                || brotherhoodMatcher( name ).matches()
                || scribeMatcher( name ).matches()
                || pageMatcher( name ).matches();

    }

    public static boolean isComponent( String name ) {
        return !isActor( name );
    }

}
