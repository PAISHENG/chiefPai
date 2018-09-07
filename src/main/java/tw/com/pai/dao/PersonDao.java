package tw.com.pai.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tw.com.pai.model.Person;

@Repository
public class PersonDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void insert(Person person){
		String sql = "INSERT INTO person (fistname,lastname,description) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, new Object[] { person.getFirstName(),
			person.getLastName(),person.getDescription()
		});
	}
	
	public List<Person> findAll(){
		List<Person> result =null;
		
		String sql = "select * from person";
//		
//		result=jdbcTemplate.query(sql, rowMapper);
		return result;
		
	}
	
	public static void main(String args[]){
		PersonDao personDao=new PersonDao();
		Person person=new Person();
		person.setFirstName("pai");
		person.setLastName("indc");
		person.setDescription("123323");
		personDao.insert(person);
		
//		List<Person> result=personDao.findAll();
//		System.out.println(result.size());
//		for(Person temp:result){
//			System.out.println(temp.getFirstName());
//		}
	}
}
