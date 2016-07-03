package com.windwagon.broceliande.knights.forge.builder;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ClassUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.windwagon.broceliande.knights.entities.ComponentClass;
import com.windwagon.broceliande.knights.entities.JARFile;
import com.windwagon.logres.builder.Builder;
import com.windwagon.logres.builder.SortedSetCachedBuilder;

public class ComponentClassBuilder implements Builder<ComponentClass> {

    @Autowired
    private KnightBuilderFactory knightBuilderFactory;

    private ComponentClass componentClass = new ComponentClass();

    /*
     * MainClass
     */

    public ComponentClassBuilder mainClass( Class<?> mainClass ) {

        componentClass.setMainClass( mainClass.getCanonicalName() );

        componentClass.setTypes(
                ClassUtils.getAllInterfaces( mainClass ).stream().map( c -> c.getCanonicalName() ).collect(
                        Collectors.toCollection( TreeSet::new ) ) );

        return this;

    }

    public ComponentClassBuilder mainClass( String mainClass ) {
        componentClass.setMainClass( mainClass );
        return this;
    }

    /*
     * Description
     */

    public ComponentClassBuilder description( String description ) {
        componentClass.setDescription( description );
        return this;
    }

    /*
     * Types
     */

    public ComponentClassBuilder types( SortedSet<String> types ) {
        componentClass.setTypes( types );
        return this;
    }

    public ComponentClassBuilder addType( String type ) {

        if( componentClass.getTypes() == null )
            componentClass.setTypes( new TreeSet<>() );

        componentClass.getTypes().add( type );

        return this;

    }

    /*
     * Official Id
     */

    public ComponentClassBuilder officialId( String officialId ) {
        componentClass.setOfficialId( officialId );
        return this;
    }

    /*
     * JAR files
     */

    private SortedSetCachedBuilder<JARFile, JARFileBuilder> jarFileBuilder =
            new SortedSetCachedBuilder<>( () -> knightBuilderFactory.getJARFileBuilder() );

    public ComponentClassBuilder jarFiles( SortedSet<JARFile> jarFiles ) {
        jarFileBuilder.set( jarFiles );
        return this;
    }

    public ComponentClassBuilder addJarFile( JARFile jarFile ) {
        jarFileBuilder.add( jarFile );
        return this;
    }

    public JARFileBuilder jarFile() {
        return jarFileBuilder.builder();
    }

    /*
     * Build
     */

    @Override
    public ComponentClass build() {

        componentClass.setJarFiles( jarFileBuilder.build() );

        return componentClass;

    }

}
