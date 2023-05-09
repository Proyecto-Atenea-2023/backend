package com.sergioarboleda.ren_car.repositories;

import com.sergioarboleda.ren_car.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 *
 */
@Repository
public class CarRepository {
    @Autowired
    private CarCRUDRepository carCRUDRepository;

    /**
     *
     * @return
     */

    public List<Car> getAll() {
        return (List<Car>) carCRUDRepository.findAll();
    }

    /**
     *
     * @param year
     * @return
     */

    public List<Car> getAllByYear(Integer year) {
        return carCRUDRepository.findByYear(year);
    }

    /**
     *
     * @param carId
     * @return
     */

    public Optional<Car> getById(Integer carId){
        return carCRUDRepository.findById(carId);
    }

    /**
     *
     * @param plate
     * @return
     */

    public Optional<Car> getByPlate(String plate) {
        return carCRUDRepository.findByPlate(plate);
    }

    /**
     *
     * @param car
     * @return
     */

    public  Car save(Car car){
        return carCRUDRepository.save(car);
    }

    /**
     *
     * @param car
     */

    public void delete(Car car){
        carCRUDRepository.delete(car);
    }
}
