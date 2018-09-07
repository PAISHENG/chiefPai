package tw.com.pai.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.com.pai.model.Car;
import tw.com.pai.model.Stock;
import tw.com.pai.model.hibernate.HUsers;
import tw.com.pai.model.jpa.JMember;
import tw.com.pai.service.CarService;
import tw.com.pai.service.IMailService;
import tw.com.pai.service.IStockService;
import tw.com.pai.service.IUserService;
import tw.com.pai.service.MemberService;
import tw.com.pai.utils.ZipWorkUtils;

@Controller
public class TestController {
	
	@Autowired
	private IMailService mailSender;
	@Autowired
	private CarService carService;
	@Autowired
	private IStockService iStockService;
	@Autowired
	private IUserService  iUserService;
	@Autowired
	private MemberService  memberService;

	@RequestMapping("mailTest")
	public void sendMail(){
		System.out.println("======start to sent email=============");
		String message = "<i>Greetings!</i><br>";
        message += "<b>Wish you a nice day!</b><br>";
        message += "<font color=red>pai</font>";
		try {
			mailSender.htmlFormEmailSender("smtp.gmail.com", "587", "martinharrt@gmail.com", "123456", "martinharrt@gmail.com", "Hello my friend", message);
		} catch (MessagingException e) {
			 System.out.println("Failed to sent email.");
			e.printStackTrace();
		}
	}

	@RequestMapping("carTest1")
	public void carQuery1(){
		System.out.println("======start to method about Car=============");
		List<Car> result=carService.findAllCars();
		for (Car temp : result){
			System.out.println(temp.getId()+ " 的color 屬性為: " + temp.getColor() );
		}
	}
	
	@RequestMapping("carTest2")
	public void carQuery2(){
		System.out.println("======start to method about Car=============");
		List<Car> result=carService.selectAllCar2();
		for (Car temp : result){
			System.out.println(temp.getId()+ " 的color 屬性為: " + temp.getColor() );
		}
	}
	
	@RequestMapping("chartList")
	public String chartList(){
		System.out.println("======start to chart List=============");
		return "/charts/chartList";
	}
	
	
	@RequestMapping("testZipWork")
	public String testZipWork(){
		System.out.println("======start to testZipWork=============");
		ZipWorkUtils.doUnzipFile("C:\\Users\\scpai\\Desktop\\testZip\\", "sftp.zip", "C:\\Users\\scpai\\Desktop\\testZip\\");
		return "/charts/chartList";
	}
	
	@RequestMapping("testStock")
	public String testStockService(){
		System.out.println("======start to testStock=============");
		Stock data=new Stock();
		data.setStockCode("10089");
		data.setStockName("tw.test2");
		iStockService.save(data);
		return "/charts/chartList";
	}
	
	@RequestMapping("testUsers")
	public String testUsers(){
		System.out.println("======start to testUsers=============");
		HUsers data=new HUsers();
		data.setFirstName("pai");
		data.setLastName("sheng chieh");
		data.setEmail("martinharrt@gmail.com");
		iUserService.add(data);
		return "/charts/chartList";
	}
	
	
	@RequestMapping("testJpaMembers")
	public String testJpaMembers(){
		System.out.println("======start to testJpaMembers=============");
		JMember data=new JMember();
		data.setName("pai");
		data.setGender(Integer.parseInt("0"));
		data.setEmail("123@gmail.com");
		data.setNickname("uu");
		data.setScore(String.valueOf(0));
		data.setPhone("0920100222");
		data.setPassword("cc1234556");
		memberService.addMember(data);
		return "/charts/chartList";
	}
}
