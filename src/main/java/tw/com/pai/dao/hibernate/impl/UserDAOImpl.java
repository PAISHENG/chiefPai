package tw.com.pai.dao.hibernate.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import tw.com.pai.dao.hibernate.IUserHibernateDAO;
import tw.com.pai.model.hibernate.HUsers;

@Repository
public class UserDAOImpl implements IUserHibernateDAO {

	@Autowired
	@Qualifier("getSessionFactory") 
	private SessionFactory sessionFactory;

	@Override
	public void add(HUsers user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public List<HUsers> getUsers() {
		@SuppressWarnings("unchecked")
		TypedQuery<HUsers> query = (TypedQuery<HUsers>) sessionFactory.getCurrentSession().createQuery("from Users");
		return query.getResultList();
//		return null;
	}

}
