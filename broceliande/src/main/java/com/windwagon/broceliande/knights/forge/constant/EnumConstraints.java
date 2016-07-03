package com.windwagon.broceliande.knights.forge.constant;

import java.util.List;

public class EnumConstraints {

    private String enumClassName;

    private List<String> enumNames;

    /**
     * @return the enumClassName
     */
    public String getEnumClassName() {
        return enumClassName;
    }

    /**
     * @param enumClassName the enumClassName to set
     */
    public void setEnumClassName( String enumClassName ) {
        this.enumClassName = enumClassName;
    }

    /**
     * @return the enumNames
     */
    public List<String> getEnumNames() {
        return enumNames;
    }

    /**
     * @param enumNames the enumNames to set
     */
    public void setEnumNames( List<String> enumNames ) {
        this.enumNames = enumNames;
    }

}
