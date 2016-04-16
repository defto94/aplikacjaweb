/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.RegistrationBean;
import config.DBManager;
import entity.Registration;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Aleksandra
 */

public class RegistrationController implements Serializable {

   private RegistrationBean user;
    
    public RegistrationController() {
        user = new RegistrationBean();
    }

    public RegistrationBean getUser() {
        return user;
    }

    public void setUser(RegistrationBean user) {
        this.user = user;
    }

    public String createUser()
    {
        Registration registration = new Registration();
        //registration.setId(BigDecimal.valueOf());
        registration.setLogin(user.getLogin());
        registration.setMail(user.getMail());
        registration.setPassword1(user.getPassword1());
        registration.setPassword2(user.getPassword2());
        
        EntityManager em = DBManager.getManager().createEntityManager();
        em.getTransaction().begin();
        em.persist(registration);
        em.getTransaction().commit();
        em.close();
        

        return "OK";
    }
}
