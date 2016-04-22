/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sources;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Aleksandra
 */
public class RegistrationDao {
    Session session = HibernateUtil.getSessionFactory().openSession();
    public void save(Registration user){
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}
    public Integer getId (){
		String hql = "select max(user.id) from Registration user";
		Query query = session.createQuery(hql);
		List<Integer> results = query.list();
		Integer userId = 1;
                if (results.get(0) != null ) {
        	   userId = results.get(0) + 1;
                }
                return userId;
	}
}
