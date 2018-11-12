package tw.com.pai.dao.mybatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import tw.com.pai.model.mybatis.MUser;

@Repository
public interface MUserMapper {
	 /**
     * @return all the users
     */
    public List<MUser> getAllUsers();
    /**
     * @param user
     * @return the number of rows affected
     */
    public int insertUser(MUser user);
    /**
     * @param user
     * @return the number of rows affected
     */
    public int updateUser(MUser user);
}
