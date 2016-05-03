/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bigbang.sushil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author The BigBang
 */
public class HibernateUtil {
    
    public static final HibernateUtil instance = new HibernateUtil();

    private SessionFactory sessionFactory;

    private HibernateUtil(){
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            Configuration config = new Configuration();
          config.addAnnotatedClass(com.bigbang.sushil.Fish.class);
           config.addAnnotatedClass(com.bigbang.sushil.Animal.class);
            config.addAnnotatedClass(com.bigbang.sushil.ElectricEel.class);
            config.addAnnotatedClass(com.bigbang.sushil.Planet.class);
          config.addAnnotatedClass(com.bigbang.sushil.SolarSystem.class);
           config.addAnnotatedClass(com.bigbang.sushil.Students.class);
           config.addAnnotatedClass(com.bigbang.sushil.Unistudent.class);
          config.addAnnotatedClass(com.bigbang.sushil.nerdIt.class);
         
            
            config.configure("hibernate.cfg.xml");
            new SchemaExport(config).create(true, true);
            StandardServiceRegistryBuilder serviceRegistryBuilder
                    = new StandardServiceRegistryBuilder();
            serviceRegistryBuilder.applySettings(config.getProperties());
            ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
            sessionFactory = config.buildSessionFactory(serviceRegistry);
            // above is peter
            Session session = sessionFactory.openSession();
            Transaction t = session.beginTransaction();
            Person p = new Person(); 
            p.setName("sonoo");
            session.save(p);
            session.getTransaction().commit(); 
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static synchronized SessionFactory getSessionFactory() {
        return instance.sessionFactory;
    }
}
