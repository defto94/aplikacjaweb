/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.faces.bean.*;
import entities.*;
import model.*;
import encrypt.*;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Aleksandra
 */
@ManagedBean(name = "usersController")
@SessionScoped
public class UsersController {

    private Users users;
    private String errorMessage = "";
    private List<Users> list = new ArrayList<>();
    public boolean zalogowany = false;
    
    
    public UsersController() {
        users = new Users();
        list.add(users);
    }
    
    
      public boolean isZalogowany() {
        return zalogowany;
    }

    public void setZalogowany(boolean zalogowany) {
        this.zalogowany = zalogowany;
    }
    
   
    

    public List<Users> getList() {
        UsersModel users = new UsersModel();
        return users.findAll();
    }

    public void setList(List<Users> list) {
         this.list = list;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String save() {
        try {
            UsersModel usersModel = new UsersModel();
            this.users.setPassword(EncryptPassword.generateStorngPasswordHash(this.users.getPassword()));
            usersModel.create(users);
            
            this.errorMessage = "Twoje konto zostało pomyślnie utworzone. Możesz się już zalogować.";
            return errorMessage;
        } catch (Exception e) {
            return errorMessage;
        }

    }
    
    

    
    public String login() {
        
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            UsersModel accountModel = new UsersModel();
            Users users2 = accountModel.find(this.users.getUsername());
            
            if (users2 != null) {
                zalogowany=true;
                
                if (EncryptPassword.validatePassword(this.users.getPassword(),
                        users2.getPassword())) {
                        
                      context.getExternalContext().getSessionMap().put("users", users);
                      zalogowany=true;
                    return "main?faces-redirect=true";
                } else {
                    this.errorMessage = "Niepoprawne hasło. Proszę wpisać ponownie.";
                    return errorMessage;
                }
            } else {
                this.errorMessage = "Niepoprawna nazwa użytkownika. Proszę wpisać ponownie.";
                return errorMessage;
            }
            
        } catch (Exception e) {
            this.errorMessage = "Coś poszło nie tak. Spróbuj ponownie.";
            return errorMessage;
        }
        
    }

    public String logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.invalidate();
        return "/login?faces-redirect=true";
    }

}
