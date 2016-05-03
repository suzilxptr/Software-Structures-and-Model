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
public class nerdIt extends Unistudent {
    
      @Column (name = "Prasdasdice")
    String name;
    
    
    public String getIt() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setIt(String name) {
        this.name = name;
    }
    
    
    
}