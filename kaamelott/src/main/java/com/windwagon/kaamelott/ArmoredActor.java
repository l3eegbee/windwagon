package com.windwagon.kaamelott;

import java.util.Set;

public interface ArmoredActor<A extends Actor> {

	String getName();

	String getDescription();

	Set<? extends ConstantProp> getConstantProps();

	ConstantProp getConstantProp(String name);

	A getActor();

}
