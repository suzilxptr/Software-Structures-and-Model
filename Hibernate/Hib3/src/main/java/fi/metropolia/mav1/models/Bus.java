/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.metropolia.mav1.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 *
 * @author beochot
 */
@Entity
public class Bus extends PublicTransport implements Serializable {

    private static final long serialVersionUID = 1L;

    private String opArea;

    public Bus(){
        
    }

    public Bus(String opArea, String company, double price, String name, String model, int capacity) {
        super(company, price, name, model, capacity);
        this.opArea = opArea;
    }


    public String getOpArea() {
        return opArea;
    }

    public void setOpArea(String opArea) {
        this.opArea = opArea;
    }
    
}
