package com.windwagon.kaamelott;

import java.util.Set;

public interface ArmoredActor < A extends Actor > {

    public String getName();

    public String getDescription();

    public Set<? extends ConstantProp> getConstantProps();

    public ConstantProp getConstantProp( String name );

    public A getActor();

}
