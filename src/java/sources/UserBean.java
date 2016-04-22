/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sources;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Aleksandra
 */
@ManagedBean(name = "userBean", eager = true)
@RequestScoped
public class UserBean {
    
   
    private String login;
    private String mail;
    private String password1;
    private String password2;
    public String saveUser(){
		RegistrationDao userDao = new RegistrationDao();
		Integer userId= userDao.getId();
		Registration user = new Registration(userId, login, mail, password1, password2);
		userDao.save(user);
		System.out.println("User successfully saved.");
		return "registrationOutput";
    }
    /**
     * Creates a new instance of UserBean
     */
    
   

    public String getLogin() {
        return login;
    }

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
        
    
    public UserBean() {
    }
    
}
