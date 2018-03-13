package tw.com.pai.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tw.com.pai.model.Customer;


@Repository
public class CustomerDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void insert(Customer customer){
		String sql = "INSERT INTO Customer  vALUES (?, ?, ?)";
		System.out.println(sql);
		jdbcTemplate.update(sql, new Object[] { customer.getCustId(),
				customer.getName(),customer.getAge()
		});
	}}


