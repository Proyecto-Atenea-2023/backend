package com.sergioarboleda.ren_car.repositories;

import com.sergioarboleda.ren_car.models.CarType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CarTypeRepository {

    @Autowired
    private CarTypeCRUDRepository carTypeCRUDRepository;

    /**
     *
     * @return
     */

    public List<CarType> getAll(){
        return (List<CarType>) carTypeCRUDRepository.findAll();
    }

    /**
     *
     * @param carTypeId
     * @return
     */

    public Optional<CarType> getById(Integer carTypeId) {
        return carTypeCRUDRepository.findById(carTypeId);
    }

    /**
     *
     * @param carType
     * @return
     */

    public CarType save(CarType carType){
        return carTypeCRUDRepository.save(carType);
    }

    /**
     *
     * @param carType
     */

    public void delete(CarType carType) {
        carTypeCRUDRepository.delete(carType);
    }
}
