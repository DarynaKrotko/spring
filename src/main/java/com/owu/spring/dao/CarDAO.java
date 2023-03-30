package com.owu.spring.dao;

import com.owu.spring.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarDAO extends JpaRepository<Car, Integer> {
//    @Query("select c from Car c where c.power =: power")
//    List<Car> getCarsByPower(@Param("power") int power);

    List<Car> findCarByPower(int power);
    List<Car> findCarsByProducer(String producer);

}
