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


    /**
     *
     * @param employ
     * @return
     */
    public Employ insertEmploy(Employ employ) {
        if (employ.getName() != null)
            return employRepository.save(employ);
        else
            return employ;
    }

    /**
     *
     * @param employ
     * @return
     */
    public Employ updateEmploy(Employ employ) {
        if (employ.getIdEmploy() != null){
            Optional<Employ> temp = getEmployById(employ.getIdEmploy());
            if (temp.isPresent()) {
                if (employ.getName() != null)
                    temp.get().setName(employ.getName());
                if (employ.getIsAdmin() != null)
                    temp.get().setIsAdmin(employ.getIsAdmin());
                return employRepository.save(temp.get());
            }
            else
                return employ;
        }
        else
            return employ;

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
