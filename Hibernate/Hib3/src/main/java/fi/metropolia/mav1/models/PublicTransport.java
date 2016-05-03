/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.metropolia.mav1.models;

import java.io.Serializable;
import javax.persistence.Entity;


/**
 *
 * @author beochot
 */
@Entity
public class PublicTransport extends Transportation implements Serializable {

    private static final long serialVersionUID = 1L;

    private String company;
    private double price;

    public PublicTransport(String company, double price, String name, String model, int capacity) {
        super(name, model, capacity);
        this.company = company;
        this.price = price;
    }
    public PublicTransport(){
        
    }
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    

}
