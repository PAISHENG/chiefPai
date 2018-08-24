package tw.com.pai.service;

import java.util.List;

import tw.com.pai.model.hibernate.HUsers;

public interface IUserService {

	void add(HUsers user);

	List<HUsers> findUsers();
}
