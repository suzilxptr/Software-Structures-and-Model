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
public class ElectricEel extends Fish {
     
    private String electricVolt;

    /**
     * @return the electricVolt
     */
    public String getElectricVolt() {
        return electricVolt;
    }

    /**
     * @param electricVolt the electricVolt to set
     */
    public void setElectricVolt(String electricVolt) {
        this.electricVolt = electricVolt;
    }
    
    
}
