package com.sergioarboleda.ren_car.services;

import com.sergioarboleda.ren_car.models.CarType;
import com.sergioarboleda.ren_car.repositories.CarTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CarTypeServices {
    @Autowired
    private CarTypeRepository carTypeRepository;

    /**
     *
     * @return
     */
    public List<CarType> getAllCarTypes() {
        return carTypeRepository.getAll();
    }

    /**
     *
     * @param carTypeId
     * @return
     */
    public Optional<CarType> getCarTypeById(Integer carTypeId) {
        if(carTypeId < 1) //Autoincrement does not have negative valor
            return null;
        return carTypeRepository.getById(carTypeId);
    }

    public CarType insertCarType(CarType carType) {

    }

    public CarType updateCarType(CarType carType) {

    }

    /**
     *
     * @param carTypeId
     * @return
     */
    public boolean deleteCarType(Integer carTypeId) {
        Boolean success = getCarTypeById(carTypeId).map(carType -> {
            carTypeRepository.delete(carType);
            return true;
        }).orElse(false);
        return success;
    }
}
