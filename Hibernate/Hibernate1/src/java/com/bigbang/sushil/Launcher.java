/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bigbang.sushil;

import javax.ws.rs.Path;
import org.hibernate.Session;



/**
 *
 * @author The BigBang
 */

@Path("get")
public class Launcher {
    
   public static void createTable(){
      Person p = new Person();
        p.setName("sushil");
        Person p1 = new Person();
        p1.setName("sushil1");
        Car hyundai = new Car();
        hyundai.setOwner(p);
        hyundai.setPrice(500);
        Car kia = new Car();
        kia.setOwner(p);
        kia.setPrice(1123);
        Car peugeot = new Car();
        peugeot.setOwner(p1);
        peugeot.setPrice(122);        
        p.getCars().add(hyundai);
        p.getCars().add(kia);
        p1.getCars().add(peugeot);
        
        Session session
                = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(p);
        session.saveOrUpdate(p1);
        session.saveOrUpdate(peugeot);
        session.saveOrUpdate(kia); 
        session.saveOrUpdate(hyundai);
      
       
      Animal a=new Animal();
         a.setName("Animal");
         
         Fish f=new Fish();
         f.setFishName("Electric fish");
         f.setName("Fish");
         
         ElectricEel e=new ElectricEel();
         e.setFishName("ElectricEel");
         e.setName("Dangeorus Animal");
         e.setElectricVolt("123V");
         
         Universe u=new Universe();
         u.setUniverseName("Laniakea");
         
         SolarSystem s=new SolarSystem();
         s.setSolarName("MilkyWaygalaxy");
         s.setUniverseName("Laniakea");
         
         Planet p3=new Planet();
         p3.setPlanetName("Earth");
         p3.setUniverseName("Milkyway");
         p3.setUniverseName("Lukaaaa");
         
         
         Students s1=new Students();
         s1.setName("Student");
         
         
         Unistudent us=new Unistudent();
         us.setName("Metropolia Student");
         us.setUNi("Metropolia");
         
         
         nerdIt nerd=new nerdIt();
         nerd.setName("IT Student");
         nerd.setUNi("Metropolia");
         nerd.setIt("Metropolia's Nerd");
      
          session.saveOrUpdate(a);
        session.saveOrUpdate(f);
        session.saveOrUpdate(e);
        session.saveOrUpdate(u); 
        session.saveOrUpdate(s);
        session.saveOrUpdate(p3);
        session.saveOrUpdate(s1); 
        session.saveOrUpdate(us);
        session.saveOrUpdate(nerd);

           // save changes in object graph starting at t
        // save changes in object graph starting at u
        session.getTransaction().commit();
        session.close();
      
         
         
   
   }
    
}
