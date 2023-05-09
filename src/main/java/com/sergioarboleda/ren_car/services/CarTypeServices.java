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

    /**
     *
     * @param carType
     * @return
     */
    public CarType insertCarType(CarType carType) {
        if (carType.getLevel() != null)
            return carTypeRepository.save(carType);
        else
            return carType;
    }

    /**
     *
     * @param carType
     * @return
     */
    public CarType updateCarType(CarType carType) {
        if (carType.getCarTypeId() != null){
            Optional<CarType> temp= carTypeRepository.getById(carType.getCarTypeId());
            if (temp.isPresent()) {
                if (carType.getLevel() != null)
                    temp.get().setLevel(carType.getLevel());
                if (carType.getLine() != null)
                    temp.get().setLine(carType.getLine());
                return  carTypeRepository.save(temp.get());
            }
            else
                return carType;
        }
        else
            return carType;

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
