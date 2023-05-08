package com.sergioarboleda.ren_car.services;

import com.sergioarboleda.ren_car.models.Employ;
import com.sergioarboleda.ren_car.repositories.EmployRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EmployServices {
    @Autowired
    private EmployRepository employRepository;

    /**
     *
     * @return
     */
    public List<Employ> getAllEmployees() {
        return employRepository.getAll();
    }

    /**
     *
     * @param employId
     * @return
     */
    public Optional<Employ> getEmployById(Integer employId) {
        return employRepository.getById(employId);
    }

    public Employ insertEmploy(Employ employ) {

    }
    public Employ updateEmploy(Employ employ) {

    }

    /**
     *
     * @param employId
     * @return
     */
    public boolean deleteEmploy(Integer employId) {
        Boolean success = getEmployById(employId).map(employ -> {
            employRepository.delete(employ);
            return true;
        }).orElse(false);
        return success;
    }
}
