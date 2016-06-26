package com.windwagon.avalon.simple;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.windwagon.kaamelott.Knight;
import com.windwagon.kaamelott.race.BetType;
import com.windwagon.kaamelott.race.Horse;
import com.windwagon.kaamelott.race.Race;
import com.windwagon.kaamelott.words.Bet;
import com.windwagon.kaamelott.words.BetWords;

public class SimpleKnight implements Knight {

    private Parameters constants = new Parameters();

    private Parameters variables = new Parameters();

    @Override
    public BetWords getWords( Race race ) {

        Horse horse = race.getHorses().first();
        return new BetWords( new Bet( BetType.SIMPLE_GAGNANT, horse ) );

    }

    @Override
    public byte[] marshal() {

        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        try( ObjectOutputStream out = new ObjectOutputStream( stream ) ) {
            out.writeObject( variables );
        } catch( IOException ex ) {
            throw new IllegalArgumentException( ex );
        }

        return stream.toByteArray();

    }

    @Override
    public void unmarshal( byte[] data ) {

        InputStream stream = new ByteArrayInputStream( data );

        try( ObjectInputStream in = new ObjectInputStream( stream ) ) {
            variables = (Parameters) in.readObject();
        } catch( ClassNotFoundException | IOException ex ) {
            throw new IllegalArgumentException( ex );
        }

    }

    /**
     * @return the constants
     */
    public Parameters getConstants() {
        return constants;
    }

    /**
     * @param constants the constants to set
     */
    public void setConstants( Parameters constants ) {
        this.constants = constants;
    }

    /**
     * @return the variables
     */
    public Parameters getVariables() {
        return variables;
    }

    /**
     * @param variables the variables to set
     */
    public void setVariables( Parameters variables ) {
        this.variables = variables;
    }

}
