package tw.com.pai.utils;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public abstract class CustomHibernateDaoSupport extends HibernateDaoSupport {

	@Autowired
	public void anyMethodName(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	// @Autowired
	// private SessionFactory sessionFactory;
	//
	// protected Session getCurrentSession() {
	// return sessionFactory.getCurrentSession();
	// }
}
