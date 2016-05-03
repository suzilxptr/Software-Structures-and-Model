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
public class Fish extends Animal {
    
    private String FishName;

    /**
     * @return the name
     */
    public String getFishName() {
        return FishName;
    }

    /**
     * @param FishName the name to set
     */
    public void setFishName(String FishName) {
        this.FishName = FishName;
    }
    
    
    
    
}
