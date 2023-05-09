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
        // TODO how to deal with car to insert with an ID?
        if ( (car.getPlate() != null) && (car.getYear() != null) && (car.getBrand() != null) &&
                (car.getColor() != null) && (car.getCarTypeFK() != null) ) {
            Optional<Car> temp = carRepository.getByPlate(car.getPlate());
            if (temp.isEmpty() && car.getYear() > 1950)
                return carRepository.save(car);
            else
                return car;
        }
        else
            return car;
    }

    /**
     *
     * @param car
     * @return
     */
    public Car updateCar(Car car) {
        if (car.getIdCar() != null){
            Optional<Car> temp = carRepository.getById(car.getIdCar());
            if (temp.isPresent()) {
                if (car.getBrand() != null)
                    temp.get().setBrand(car.getBrand());
                if (car.getColor() != null)
                    temp.get().setColor(car.getColor());
                if (car.getCarTypeFK() != null)
                    temp.get().setCarTypeFK(car.getCarTypeFK());
                return carRepository.save(temp.get());
            }
            else
                return car;
        }
        else
            return car;
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
