package tw.com.pai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.pai.dao.jpa.MemberRepository;
import tw.com.pai.model.jpa.JMember;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository jpaMemberRepository;
	
	
	public List<JMember> getAllMembers() {
		return jpaMemberRepository.findAll();
	}
	
	@Transactional("jpaTransactionManager")
	public boolean addMember(JMember data) {
		return jpaMemberRepository.save(data) != null;
	}

	@Transactional("jpaTransactionManager")
	public boolean updateMember(JMember data) {
		return jpaMemberRepository.save(data) != null;
	}
}
