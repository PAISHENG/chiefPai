package tw.com.pai.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.com.pai.dao.mybatis.CarMapper;
import tw.com.pai.model.Car;
import tw.com.pai.service.CarService;
import tw.com.pai.service.IMailService;

@Controller
public class TestController {
	
	@Autowired
	private IMailService mailSender;
	@Autowired
	private CarService carService;

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
}
