package com.sergioarboleda.ren_car.services;

import com.sergioarboleda.ren_car.models.Car;
import com.sergioarboleda.ren_car.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class CarServices {
    @Autowired
    private CarRepository carRepository;

    /**
     *
     * @return
     */
    public List<Car> getAllCars() {
        return this.carRepository.getAll();
    }

    /**
     *
     * @param year
     * @return
     */
    public List<Car> getAllCarsByYear(Integer year) {
        if(year < 1980) // There is no cars older than 1980
            return null;
        return carRepository.getAllByYear(year);
    }

    /**
     *
     * @param carId
     * @return
     */
    public Optional<Car> getCarById(Integer carId) {
        return carRepository.getById(carId);
    }

    /**
     *
     * @param plate
     * @return
     */
    public Optional<Car> getCarByPlate(String plate) {
        // TODO Verify plate regular expression (regex): [A-z]^3 [0-9]^3
        return carRepository.getByPlate(plate);
    }

    /**
     *
     * @param car
     * @return
     */
    public Car insertCar(Car car) {

    }

    public Car updateCar(Car car) {

    }

    /**
     *
     * @param carId
     * @return
     */
    public boolean deleteCar(Integer carId) {
        Boolean success = getCarById(carId).map(car -> {
            carRepository.delete(car);
            return true;
        }).orElse(false);
        return success;
    }
}
