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

    /**
     *
     * @param pqr
     * @return
     */
    public PQR insertPQR(PQR pqr) {
        if ( (pqr.getContent() != null) && (pqr.getType() != null) && (pqr.getClientFK() != null) )
            return pqrRepository.save(pqr);
        else
            return pqr;
    }

    /**
     *
     * @param pqr
     * @return
     */
    public PQR updatePQR(PQR pqr) {
        if (pqr.getIdPqr() != null){
            Optional<PQR> temp = pqrRepository.getById(pqr.getIdPqr());
            if (temp.isPresent()) {
                if (pqr.getContent() != null)
                    temp.get().setContent(pqr.getContent());
                return pqrRepository.save(temp.get());
            }
            else
                return pqr;
        }
        else
            return pqr;
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
