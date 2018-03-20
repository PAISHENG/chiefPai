package tw.com.pai.dao;

import java.util.List;
import tw.com.pai.model.User;

public interface UserMapper {

	public void insertUser(User user);

	public User getUserById(Integer id);

	public List<User> getAllUsers();

	public void updateUser(User user);

	public void deleteUser(Integer id);

}
