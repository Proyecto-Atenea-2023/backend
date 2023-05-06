package com.sergioarboleda.ren_car.repositories;

import com.sergioarboleda.ren_car.models.CarType;
import org.springframework.data.repository.CrudRepository;

public interface CarTypeCRUDRepository extends CrudRepository<CarType, Integer> {
}
