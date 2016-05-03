/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.metropolia.mav1.service;


import fi.metropolia.mav1.models.Bicycle;
import fi.metropolia.mav1.models.Bus;
import fi.metropolia.mav1.models.Person;
import fi.metropolia.mav1.models.Plane;
import fi.metropolia.mav1.models.PrivateTransport;
import fi.metropolia.mav1.models.PublicTransport;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;
import fi.metropolia.mav1.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author beochot
 */
@WebListener
public class StartupListener implements javax.servlet.ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("StartupListener contextInitialized()");
        HibernateUtil.getInstance();
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        session.beginTransaction();
        Person p = new Person("Vegeta");
        Person p2 = new Person("Goku");
        PrivateTransport prit = new PrivateTransport(p,true,"Bugatti","X347",4);
        PublicTransport pubt = new PublicTransport("HSL",500,"Airbus","357",4);
        Bus bus = new Bus("Espoo","HSL",5,"Express","110T",60);
        Plane plane = new Plane("Hel-SGN","Finair",500,"Boeing","787",200);
        Bicycle bike = new Bicycle("Helmet",p2,true,"Giant","47",1);
        PrivateTransport prit2 = new PrivateTransport(p,true,"Limusine","Extra",6);
        PublicTransport pubt2 = new PublicTransport("VR Liner",500,"VR Line","U",4);
        Bus bus2 = new Bus("Turku","Omnibus",10,"Express","230",100);
        Plane plane2 = new Plane("Hel-Moscow","Aeroflot",500,"Airbus","444",100);
        Bicycle bike2 = new Bicycle("",p2,true,"Miyata","A86",2);
        
        session.saveOrUpdate(p);
        session.saveOrUpdate(p2);
        session.saveOrUpdate(bus);
        session.saveOrUpdate(plane);
        session.saveOrUpdate(bike);
        session.saveOrUpdate(prit);
        session.saveOrUpdate(pubt);
        session.saveOrUpdate(bus2);
        session.saveOrUpdate(plane2);
        session.saveOrUpdate(bike2);
        session.saveOrUpdate(prit2);
        session.saveOrUpdate(pubt2);

        session.getTransaction().commit();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("StartupListener contextDestroyed()");
    }

}
