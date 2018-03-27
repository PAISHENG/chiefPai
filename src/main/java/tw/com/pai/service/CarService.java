package tw.com.pai.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.pai.dao.mybatis.CarMapper;
import tw.com.pai.model.Car;

@Service 
public class CarService {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	@Autowired
	private CarMapper carMapper;
	
	public List<Car> findAllCars() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
			return carMapper.selectAllCar();
		} finally {
			sqlSession.close();
		}
	}
	
	public List<Car> findAllCars2() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
			return carMapper.selectAllCar2();
		} finally {
			sqlSession.close();
		}
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
