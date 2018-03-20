package tw.com.pai.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import tw.com.pai.model.Car;

public interface CarMapper {

	/******************************************
	    * Retrieves the List of car 
	    * @return person list
	    */
	    //SQL query in xml "Mapper.xml"
	    public List<Car> selectAllCar();
	    /******************************************
	    * Retrieves a person 
	    * @param person id
	    * @return person
	    */
	    //SQL query using annotation
	    @Select("SELECT * FROM car")
	    public List<Car> selectAllCar2();
	   
	    /******************************************
	    * Retrieves a person 
	    * @param person id
	    * @return person
	    */
	    //SQL query using annotation
	    @Select("SELECT * FROM car WHERE id = #{id}")
	    public Car selectCar(@Param("id") int id);
	   
	    /******************************************
	    * Insert a person 
	    * @param person
	    * @return int
	    */
	    @Insert("INSERT INTO car (color) VALUES (#{color})")
	    public int insertCar(Car car);
}
