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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author The BigBang
 */
@XmlRootElement
@Entity


public class Car {
    
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn (name = "Owner",
            nullable=false)
    private Person owner;
    
    @Column (name = "Price")
    private double price;

    public Person getOwner() {
        return owner;
    }

    @XmlElement
    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public double getPrice() {
        return price;
    }

    @XmlElement
    public void setPrice(double price) {
        this.price = price;
    }
    
}