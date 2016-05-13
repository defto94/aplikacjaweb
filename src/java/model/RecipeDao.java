/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Recipes;
import java.util.*;
import model.*;
import org.hibernate.*;

public class RecipeDao {

    public List<Recipes> findAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Recipes> list = new ArrayList<>();
        try {
            session.beginTransaction();
            list = session.createCriteria(Recipes.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();

        }
        return list;
    }

    public void create(Recipes re) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            session.beginTransaction();
            session.save(re);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
}
