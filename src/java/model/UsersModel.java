package model;

import org.hibernate.Query;

import entities.Users;

public class UsersModel extends AbstractModel<Users> {

	public UsersModel() {
		super(Users.class);
	}

	public Users login(String username, String password) {
		try {
			if (!sessionFactory.getCurrentSession().getTransaction().isActive())
				sessionFactory.getCurrentSession().getTransaction().begin();
			Query query = sessionFactory.getCurrentSession()
					.createQuery("select u from USERS u where "
							+ "u.username = :username and "
							+ "u.password = :password");
			query.setString("username", username);
			query.setString("password", password);
			return (Users) query.uniqueResult();
		} catch (Exception e) {
			return null;
		}
	}

}
