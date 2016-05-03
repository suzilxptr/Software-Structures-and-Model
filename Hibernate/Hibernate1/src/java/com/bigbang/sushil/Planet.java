/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bigbang.sushil;

import javax.persistence.Column;
import javax.persistence.Entity;



/**
 *
 * @author The BigBang
 */
@Entity
public class Planet extends SolarSystem {
     
    
    private String PlanetName;

    /**
     * @return the name
     */
    public String getPlanetName() {
        return PlanetName;
    }

    /**
     * @param name the name to set
     */
    public void setPlanetName(String name) {
        this.PlanetName = name;
    }
    
    
}
