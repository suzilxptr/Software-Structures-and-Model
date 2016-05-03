/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.metropolia.mav1.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author beochot
 */
@Entity
public class Bicycle extends PrivateTransport implements Serializable {

    private static final long serialVersionUID = 1L;
    private String gear;

    public Bicycle() {
    }

    public Bicycle(String gear, Person owner, boolean hasInsurance, String name, String model, int capacity) {
        super(owner, hasInsurance, name, model, capacity);
        this.gear = gear;
    }

    public String getGear() {
        return gear;
    }

    public void setGear(String gear) {
        this.gear = gear;
    }
    
    
}
