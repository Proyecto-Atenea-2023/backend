package com.sergioarboleda.ren_car.repositories;

import com.sergioarboleda.ren_car.models.Employ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployRepository {
@Autowired
    private EmployCRUDRepository employCRUDRepository;

    /**
     *
     * @return
     */

    public List<Employ> getAll() {
        return (List<Employ>) employCRUDRepository.findAll();
    }

    /**
     *
     * @param employId
     * @return
     */

    public Optional<Employ> getById(Integer employId) {
        return employCRUDRepository.findById(employId);
    }

    /**
     *
     * @param employ
     * @return
     */

    public Employ save(Employ employ) {
        return employCRUDRepository.save(employ);
    }

    /**
     *
     * @param employ
     */

    public void delete(Employ employ){
        employCRUDRepository.delete(employ);
    }
}
