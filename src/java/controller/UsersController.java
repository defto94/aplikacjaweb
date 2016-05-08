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

    private Users users = new Users();
    private String errorMessage = "";

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
            return "login?faces-redirect=true";
        } catch (Exception e) {
            this.errorMessage = "Nie mozna utworzyc konta.";
            return "registration?faces-redirect=true";
        }

    }

    public String login() {
        try {
            UsersModel accountModel = new UsersModel();
            Users users2 = accountModel.find(this.users.getUsername());
            if (users2 != null) {
                if (EncryptPassword.validatePassword(this.users.getPassword(),
                        users2.getPassword())) {
                    return "welcome?faces-redirect=true";
                } else {
                    this.errorMessage = "Account's Invalid";
                    return "login?faces-redirect=true";
                }
            } else {
                this.errorMessage = "Account's Invalid";
                return "login?faces-redirect=true";
            }
        } catch (Exception e) {
            this.errorMessage = "Account's Invalid";
            return "login?faces-redirect=true";
        }
    }

    public String logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.invalidate();
        return "/login?faces-redirect=true";
    }

    public void wiadomosc(String s) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, s, ""));
    }
}
