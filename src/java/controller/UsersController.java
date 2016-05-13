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
            this.errorMessage = "Twoje konto zostało pomyślnie utworzone. Możesz się już zalogować.";
            return errorMessage;
        } catch (Exception e) {
            this.errorMessage = "Nie można utworzyć konta. Użytkownik o podanym loginie już istnieje.";
            return errorMessage;
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
