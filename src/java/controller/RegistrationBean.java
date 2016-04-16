/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.DBManager;
import entity.Registration;
import javax.persistence.EntityManager;

/**
 *
 * @author Aleksandra
 */
public class RegistrationBean {
    private Registration user = new Registration();
    public RegistrationBean() {
        
    }
    public Registration getRegistration() {
        return user;
    }
    public void setRegistration(Registration user) {
        this.user=user;
    }
    public String save() {
        EntityManager em = DBManager.getManager().createEntityManager();
        em.getTransaction().begin();
        user.setId(null);    
        em.persist(user);
        em.getTransaction().commit();
        em.close();
        this.user=new Registration();
        return null;
    }
}
