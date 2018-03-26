package tw.com.pai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.pai.dao.mybatis.CarMapper;
import tw.com.pai.model.Car;

public class CarService {


	private CarMapper carMapper;

	
	public void setCarMapper(CarMapper carMapper) {
		this.carMapper = carMapper;
	}

	public List<Car> selectAllCar() {
		return carMapper.selectAllCar();
	}
	
	public List<Car> selectAllCar2() {
		return carMapper.selectAllCar2();
	}

	public Car selectCar(int id) {
		return carMapper.selectCar(id);
	}

	public int insertPerson(Car data) {
		return carMapper.insertCar(data);
	}
}
