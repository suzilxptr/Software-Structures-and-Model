/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bigbang.sushil;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author The BigBang
 */
@XmlRootElement
//@Entity(name ="Person_Table")
@Entity
public class Person {

    @Id
    @GeneratedValue
   
    private Integer Id;

   
    private String name;
    
    @OneToMany(mappedBy="owner",
            targetEntity=Car.class,
 fetch=FetchType.EAGER,
 cascade=CascadeType.ALL)
//    @JoinTable(name="Owner_Car", joinColumns=@JoinColumn(name="CarOwner"),
//            inverseJoinColumns=@JoinColumn(name="CarNumber")
//    )
    private Collection<Car> cars = new ArrayList<Car>();

    @XmlTransient
    public Collection<Car> getCars() {
        return cars;
    }

    public void setCars(Collection<Car> cars) {
        this.cars = cars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
