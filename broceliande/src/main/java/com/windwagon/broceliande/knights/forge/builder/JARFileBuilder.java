package com.windwagon.broceliande.knights.forge.builder;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;

import com.windwagon.broceliande.knights.entities.JARFile;
import com.windwagon.logres.builder.Builder;

public class JARFileBuilder implements Builder<JARFile> {

    @Autowired
    private ResourceLoader resourceLoader;

    private JARFile jarFile = new JARFile();

    /*
     * Path
     */

    public JARFileBuilder path( String path ) {
        jarFile.setPath( path );
        return this;
    }

    public JARFileBuilder resource( String resource ) {
        try {
            path( resourceLoader.getResource( resource ).getFile().getAbsolutePath() );
        } catch( IOException ex ) {
            throw new IllegalArgumentException( ex );
        }
        return this;
    }

    /*
     * Checksum
     */

    public JARFileBuilder checksum( String checksum ) {
        jarFile.setChecksum( checksum );
        return this;
    }

    /*
     * Description
     */

    public JARFileBuilder description( String description ) {
        jarFile.setDescription( description );
        return this;
    }

    /*
     * Build
     */

    @Override
    public JARFile build() {
        return jarFile;
    }

}
