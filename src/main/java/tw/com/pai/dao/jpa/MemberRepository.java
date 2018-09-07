package tw.com.pai.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.com.pai.model.jpa.JMember;


public interface MemberRepository extends JpaRepository<JMember, Integer>{

}
