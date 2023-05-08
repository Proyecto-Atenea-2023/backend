package com.sergioarboleda.ren_car.services;

import com.sergioarboleda.ren_car.models.PQR;
import com.sergioarboleda.ren_car.repositories.PqrRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PqrServices {
    @Autowired
    private PqrRepository pqrRepository;

    /**
     *
     * @return
     */
    public List<PQR> getAllPQRs() {
        return pqrRepository.getAll();
    }

    /**
     *
     * @param pqrId
     * @return
     */
    public Optional<PQR> getPQRById(Integer pqrId) {
        return pqrRepository.getById(pqrId);
    }

    public PQR insertPQR(PQR pqr) {

    }

    public PQR updatePQR(PQR pqr) {

    }

    /**
     *
     * @param pqrId
     * @return
     */
    public boolean deletePQR(Integer pqrId) {
        Boolean success = getPQRById(pqrId).map(pqr -> {
            pqrRepository.delete(pqr);
            return true;
        }).orElse(false);
        return success;
    }
}
