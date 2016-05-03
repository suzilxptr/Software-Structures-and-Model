/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bigbang.sushil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author The BigBang
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) 
public class Universe {
    @Id 
    @GeneratedValue
    private int id;
    
    private String UniverseName;

    /**
     * @return the name
     */
    public String getUniverseName() {
        return UniverseName;
    }

    /**
     * @param UniverseName the name to set
     */
    public void setUniverseName(String UniverseName) {
        this.UniverseName = UniverseName;
    }
    
    
}
