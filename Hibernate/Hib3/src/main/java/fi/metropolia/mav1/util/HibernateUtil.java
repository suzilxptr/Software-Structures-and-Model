/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.metropolia.mav1.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author beochot
 */
public class HibernateUtil {

    private static HibernateUtil instance;
    private SessionFactory sessionFactory;

    public HibernateUtil() {
        Configuration config = new Configuration();
        config.addAnnotatedClass(fi.metropolia.mav1.models.Person.class);
        config.addAnnotatedClass(fi.metropolia.mav1.models.Transportation.class);
        config.addAnnotatedClass(fi.metropolia.mav1.models.PrivateTransport.class);
        config.addAnnotatedClass(fi.metropolia.mav1.models.PublicTransport.class);
        config.addAnnotatedClass(fi.metropolia.mav1.models.Bus.class);
        config.addAnnotatedClass(fi.metropolia.mav1.models.Plane.class);
        config.addAnnotatedClass(fi.metropolia.mav1.models.Bicycle.class);
        config.configure();
        new SchemaExport(config).create(true, true);
        StandardServiceRegistryBuilder serviceRegistryBuilder
                = new StandardServiceRegistryBuilder();
        serviceRegistryBuilder.applySettings(config.getProperties());
        ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
        sessionFactory = config.buildSessionFactory(serviceRegistry);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static synchronized HibernateUtil getInstance() {
        if (instance == null) {
            instance = new HibernateUtil();
        }
        return instance;
    }

}
