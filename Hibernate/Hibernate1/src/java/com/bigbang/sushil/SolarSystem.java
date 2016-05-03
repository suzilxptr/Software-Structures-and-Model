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
public class SolarSystem extends Universe{
    
    private String SolarName;

    /**
     * @return the name
     */
    public String getSolarName() {
        return SolarName;
    }

    /**
     * @param name the name to set
     */
    public void setSolarName(String name) {
        this.SolarName = name;
    }
    
}
