package com.windwagon.avalon.simple;

import java.util.Objects;

import com.windwagon.kaamelott.ArmoredKnight;
import com.windwagon.kaamelott.DrillHall;
import com.windwagon.kaamelott.FencingMaster;

public class SimpleFencingMaster implements FencingMaster {

    private SimpleParameter parameter = new SimpleParameter();

    private DrillHall drillHall;

    private ArmoredKnight knight;

    public SimpleParameter getParameter() {
        return this.parameter;
    }

    public void setParameter( SimpleParameter parameter ) {
        this.parameter = parameter;
    }

    public DrillHall getDrillHall() {
        return this.drillHall;
    }

    public void setDrillHall( DrillHall drillHall ) {
        this.drillHall = drillHall;
    }

    @Override
    public void setKnight( ArmoredKnight knight ) {
        this.knight = knight;
    }

    @Override
    public void train() {
        SimpleKnight casted = (SimpleKnight) knight.getActor();
        casted.setParameter( parameter );
    }

    @Override
    public void getWebVisu() {}

    @Override
    public String toString() {

        return new StringBuilder()
                .append( "{parameter:" )
                .append( Objects.toString( parameter ) )
                .append( ",drillHall:" )
                .append( drillHall == null ? "null" : drillHall.size() )
                .append( "}" )
                .toString();

    }

}
