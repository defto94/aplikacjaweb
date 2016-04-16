/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import config.DBManager;
import entity.Registration;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;

/**
 *
 * @author Aleksandra
 */
public class RegistrationBean implements Serializable {

    private String login;
    private String mail;
    private String password1;
    private String password2;
    
    /**
     * Creates a new instance of RegistrationBeam
     */
    public RegistrationBean() {
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
    
    public String createUser()
    {
        Registration registration = new Registration();
        //registration.setId(BigDecimal.valueOf());
        registration.setLogin(login);
        registration.setMail(mail);
        registration.setPassword1(password1);
        registration.setPassword2(password2);
        
        EntityManager em = DBManager.getManager().createEntityManager();
        em.getTransaction().begin();
        em.persist(registration);
        em.getTransaction().commit();
        em.close();
        

        return "OK";
    }
}
