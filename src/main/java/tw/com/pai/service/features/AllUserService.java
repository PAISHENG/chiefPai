package tw.com.pai.service.features;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.pai.dao.hibernate.IUserHibernateDAO;
import tw.com.pai.dao.jdbc.JdbcMemberDAO;
import tw.com.pai.dao.jpa.MemberRepository;
import tw.com.pai.dao.mybatis.MUserMapper;
import tw.com.pai.model.mybatis.MUser;

@Service 
public class AllUserService {

	@Autowired
	JdbcMemberDAO jdbcMemberDAO;
	@Autowired
	MUserMapper mUserMapper;
	@Autowired
	IUserHibernateDAO iUserHibernateDAO;
	@Autowired
	MemberRepository memberRepository;
	
	public List<MUser> findUsers(){
		return mUserMapper.getAllUsers();
	}
	
	public int insertUser(MUser user){
		return mUserMapper.insertUser(user);
	}
 
    public int updateUser(MUser user){
    	return mUserMapper.updateUser(user);
    }
	
}
