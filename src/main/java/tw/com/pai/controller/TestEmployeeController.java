package tw.com.pai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.pai.model.Employee;
import tw.com.pai.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class TestEmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/listOfEmployee")
	private String getAllEmploees(){
		List<Employee> result= employeeService.findAllEmployees();
		return result.toString();
	}
//	@RequestMapping("/listOfEmployee")
//	public String showListOfEmployees(Model model) {
//		model.addAttribute("employeeList", employeeMapper.getAllEmployees());
//		return EMPLOYEELIST;
//	}
//
//	@RequestMapping("/showFormForAdd")
//	public String addEmployee(Model model) {
//		model.addAttribute("employee", new Employee());
//		return EMPLOYEE;
//	}
//
//	@RequestMapping("/saveProcess")
//	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
//		if (employee.getId() == null) {
//			employeeMapper.saveEmployee(employee);
//		} else {
//			employeeMapper.updateEmployee(employee);
//		}
//
//		return "redirect:/employee/listOfEmployee";
//	}
//
//	@RequestMapping("/displayUpdateForm")
//	public String showUpdateForm(@RequestParam("employeeId") int employeeId, Model model) {
//		model.addAttribute("employee", employeeMapper.findById(employeeId));
//		return EMPLOYEE;
//	}
//
//	@RequestMapping("/displayDeleteForm")
//	public String deleteEmployee(@RequestParam("employeeId") int employeeId) {
//		employeeMapper.deleteEmployee(employeeId);
//		return "redirect:/employee/listOfEmployee";
//	}
}
