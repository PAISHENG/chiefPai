package tw.com.pai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.pai.dao.EmployeeMapper;
import tw.com.pai.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	public void insert(Employee employee) {
		employeeMapper.saveEmployee(employee);
	}

	public void update(Employee employee) {
		employeeMapper.updateEmployee(employee);
	}

	public void deleteEmployee(int employeeId) {
		employeeMapper.deleteEmployee(employeeId);
	}

	public List<Employee> findAllEmployees() {
		return employeeMapper.getAllEmployees();
	}

	public Employee findById(int employeeId) {
		return employeeMapper.findById(employeeId);
	}
}
