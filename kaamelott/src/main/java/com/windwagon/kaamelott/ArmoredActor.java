package com.windwagon.kaamelott;

import java.util.SortedSet;

public interface ArmoredActor < A extends Actor > {

    public String getName();

    public String getDescription();

    public SortedSet<? extends ConstantProp> getConstantProps();

    public ConstantProp getConstantProp( String name );

    public A getActor();

}
