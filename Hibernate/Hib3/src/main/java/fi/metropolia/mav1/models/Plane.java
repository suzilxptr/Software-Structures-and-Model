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
public class Plane extends PublicTransport implements Serializable {

    private static final long serialVersionUID = 1L;
    private String opRoute;

    public Plane(String opRoute, String company, double price, String name, String model, int capacity) {
        super(company, price, name, model, capacity);
        this.opRoute = opRoute;
    }
    public Plane(){
        
    }

    public String getOpRoute() {
        return opRoute;
    }

    public void setOpRoute(String opRoute) {
        this.opRoute = opRoute;
    }
    
}
