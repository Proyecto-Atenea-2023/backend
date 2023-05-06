package com.sergioarboleda.ren_car.repositories;

import com.sergioarboleda.ren_car.models.PQR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PqrRepository {
    @Autowired
    private PqrCRUDRepository pqrCRUDRepository;

    /**
     *
     * @return
     */
    public List<PQR> getAll() {
        return (List<PQR>) pqrCRUDRepository.findAll();
    }

    /**
     *
     * @param pqrId
     * @return
     */
    public Optional<PQR> getById(Integer pqrId) {
        return pqrCRUDRepository.findById(pqrId);
    }

    /**
     *
     * @param pqr
     * @return
     */
    public PQR save(PQR pqr) {
        return pqrCRUDRepository.save(pqr);
    }

    /**
     *
     * @param pqr
     */
    public void delete(PQR pqr) {
        pqrCRUDRepository.delete(pqr);
    }
}
