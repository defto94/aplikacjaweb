/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aleksandra
 */
@Entity
@Table(name = "RECIPES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recipes.findAll", query = "SELECT r FROM Recipes r"),
    @NamedQuery(name = "Recipes.findByName", query = "SELECT r FROM Recipes r WHERE r.name = :name"),
    @NamedQuery(name = "Recipes.findByIngredients", query = "SELECT r FROM Recipes r WHERE r.ingredients = :ingredients"),
    @NamedQuery(name = "Recipes.findByRecipe", query = "SELECT r FROM Recipes r WHERE r.recipe = :recipe")})
public class Recipes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "INGREDIENTS")
    private String ingredients;
    @Basic(optional = false)
    @Column(name = "RECIPE")
    private String recipe;

    public Recipes() {
    }

    public Recipes(String name) {
        this.name = name;
    }

    public Recipes(String name, String ingredients, String recipe) {
        this.name = name;
        this.ingredients = ingredients;
        this.recipe = recipe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recipes)) {
            return false;
        }
        Recipes other = (Recipes) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Recipes[ name=" + name + " ]";
    }
    
}
