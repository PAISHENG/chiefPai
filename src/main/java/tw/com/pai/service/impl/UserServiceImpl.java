package tw.com.pai.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.pai.dao.hibernate.IUserHibernateDAO;
import tw.com.pai.model.hibernate.HUsers;
import tw.com.pai.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserHibernateDAO iUserHibernateDAO;

	
	@Override
	@Transactional("getTransactionManager")
	public void add(HUsers user) {
		iUserHibernateDAO.add(user);
	}

	@Override
	public List<HUsers> findUsers() {
		return iUserHibernateDAO.getUsers();
	}

}
