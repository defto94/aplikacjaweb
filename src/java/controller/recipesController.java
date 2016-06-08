/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Recipes;
import model.*;
import java.util.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
@ManagedBean(name="cont")
@SessionScoped

public class recipesController {
    public List<Recipes> list = new ArrayList<Recipes>();
    public Recipes re = new Recipes();
    private String errorMessage = "";
    
    
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    public Recipes getRe() {
        return re;
    }

    public void setRe(Recipes re) {
        this.re = re;
    }

    public List<Recipes> getList() {
        RecipeDao dao = new RecipeDao();
        return dao.findAll();
    }

    public void setList(List<Recipes> list) {
        this.list = list;
    }
    
    public String create(){
        RecipeDao dao=new RecipeDao();
        dao.create(this.re);
        re.setName("");
        re.setIngredients("");
        re.setRecipe("");
        this.errorMessage = "Twój przepis został pomyśłnie dodany. DZIĘKUJEMY. ";
        return "categories";
    }
    
   
}
