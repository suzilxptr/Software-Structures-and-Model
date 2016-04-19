package com.bigbang.bastolasushil.lab34;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by The BigBang on 16.3.2016.
 */
public class Creature implements Serializable {
    private ArrayList<String> creatures=new ArrayList<String>();


 public Creature(){



 }

    public void addCreature(String creature){
        getCreatures().add(creature);

    }

    public void saveCreatures(Creature c) throws IOException {
        FileOutputStream out=new FileOutputStream(new File("creature.ser"));
        ObjectOutputStream outOb=new ObjectOutputStream(out);
        outOb.writeObject(c);
        outOb.close();
        out.close();

    }

    public ArrayList<String> getCreatures() {
        return creatures;
    }

    public void setCreatures(ArrayList<String> creatures) {
        this.creatures = creatures;
    }

}
