package com.sergioarboleda.ren_car.repositories;

import com.sergioarboleda.ren_car.models.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {
@Autowired

    private ReservationCRUDRepository reservationCRUDRepository;

    /**
     *
     * @return
     */
    public List<Reservation> getAll() {
        return (List<Reservation>) reservationCRUDRepository.findAll();
    }

    /**
     *
     * @param start_date
     * @param end_date
     * @param status
     * @return
     */
    public List<Reservation> getAllByDatesAndStatus(String start_date, String end_date, String status) {
        return reservationCRUDRepository.findReservationsByDatesAndState(start_date, end_date, status);
    }

    /**
     *
     * @param reservationId
     * @return
     */
    public Optional<Reservation> getById(Integer reservationId) {
        return reservationCRUDRepository.findById(reservationId);
    }

    /**
     *
     * @param reservation
     * @return
     */
    public Reservation save(Reservation reservation) {
        return reservationCRUDRepository.save(reservation);
    }

    /**
     *
     * @param reservation
     */
    public void delete(Reservation reservation) {
        reservationCRUDRepository.delete(reservation);
    }
}
