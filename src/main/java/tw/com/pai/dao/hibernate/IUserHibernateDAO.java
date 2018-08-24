package tw.com.pai.dao.hibernate;

import java.util.List;

import tw.com.pai.model.hibernate.HUsers;

public interface IUserHibernateDAO {
	
	void add(HUsers user);

	List<HUsers> getUsers();
}
