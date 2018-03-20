package tw.com.pai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tw.com.pai.dao.mybatis.CarMapper;
import tw.com.pai.model.Car;

public class CarService {

	@Autowired
	private CarMapper carMapper;
	
	public List<Car> selectAllCar() {
	    return carMapper.selectAllCar();
	  }
	  public Car selectCar(int id) {
	    return carMapper.selectCar(id);
	  }
	  public int insertPerson(Car data){
	    return carMapper.insertCar(data);
	  }
}
