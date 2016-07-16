package com.windwagon.kaamelott;

public interface ConstantProp extends Comparable<ConstantProp> {

    public String getName();

    public String getDescription();

    public String getValue();

    public int getOrder();

    public boolean isHidden();

}
