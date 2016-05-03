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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

/**
 *
 * @author beochot
 */
@Entity
public class PrivateTransport extends Transportation implements Serializable {

    private static final long serialVersionUID = 1L;
    @OneToOne
    private Person owner;
    private boolean hasInsurance;

    public PrivateTransport(Person owner, boolean hasInsurance, String name, String model, int capacity) {
        super(name, model, capacity);
        this.owner = owner;
        this.hasInsurance = hasInsurance;
    }
    public PrivateTransport(){
        
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public boolean isHasInsurance() {
        return hasInsurance;
    }

    public void setHasInsurance(boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
    }
    
}
