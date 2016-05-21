package com.windwagon.viviane.converters;

import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.core.Completion;
import org.springframework.shell.core.Converter;
import org.springframework.shell.core.MethodTarget;
import org.springframework.stereotype.Component;

import com.windwagon.viviane.ShellConsole;

@Component
public class FileConverter implements Converter<File> {

    private static final String HOME_SYMBOL = "~";

    private static final String HOME = System.getProperty( "user.home" );

    @Autowired
    private ShellConsole shellConsole;

    @Override
    public boolean supports( Class<?> requiredType, String optionContext ) {
        return File.class.isAssignableFrom( requiredType );
    }

    @Override
    public File convertFromText( String value, Class<?> requiredType, String optionContext ) {
        return new File( expand( value ) );
    }

    @Override
    public boolean getAllPossibleValues(
            List<Completion> completions,
            Class<?> requiredType,
            String userInput,
            String optionContext,
            MethodTarget target ) {

        List<String> exts = Collections.emptyList();

        File userFile = new File( expand( userInput ) ).getAbsoluteFile();
        String userPath = userFile.getPath();

        List<File> files = null;
        if( userFile.exists() && userFile.isDirectory() ) {

            if( !userPath.endsWith( "/" ) )
                userPath = userPath + "/";

            files = getFilterFiles( userFile, "", exts );

        } else {

            File parent = userFile.getParentFile();
            if( parent == null )
                parent = userFile;

            files = getFilterFiles( parent, userFile.getName(), exts );

        }

        if( files.isEmpty() )
            return false;

        for( File file : files ) {
            String path = file.getPath();
            path = path.substring( userPath.length() );
            path = userInput + path;
            path = path.replaceAll( "\\\\", "/" );
            path = path.replaceAll( "//", "/" );
            completions.add( new Completion( path ) );
        }

        return true;
    }

    private String expand( String path ) {

        if( path == null || path.isEmpty() )
            return path;

        if( path.startsWith( HOME_SYMBOL ) )
            path = path.replaceFirst( HOME_SYMBOL, HOME );

        return path;

    }

    private List<File> getFilterFiles( File dir, String prefix, List<String> exts ) {

        List<File> files = new LinkedList<File>();

        File[] listFiles = dir.listFiles();
        if( listFiles == null )
            return Collections.emptyList();

        for( File file : listFiles )
            if( match( file, prefix, exts ) )
                files.add( file );

        if( files.size() == 1 ) {
            File file = files.get( 0 );
            if( file.isDirectory() )
                return getFilterFiles( file, "", exts );
        }

        return files;

    }

    private boolean match( File file, String prefix, List<String> exts ) {

        String name = file.getName();

        if( !prefix.isEmpty() && !name.startsWith( prefix ) )
            return false;

        if( file.isDirectory() || exts.isEmpty() )
            return true;

        for( String ext : exts )
            if( name.endsWith( ext ) )
                return true;

        return false;

    }

}
