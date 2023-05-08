package com.sergioarboleda.ren_car.services;

import com.sergioarboleda.ren_car.models.Reservation;
import com.sergioarboleda.ren_car.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

public class ReservatonServices {
    @Autowired
    private ReservationRepository reservationRepository;

    /**
     *
     * @return
     */
    public List<Reservation> getAllReservations() {
        return reservationRepository.getAll();
    }

    /**
     *
     * @param starDate
     * @param endDate
     * @param status
     * @return
     */
    public List<Reservation> getAllReservationsByDatesAndStatus(String starDate, String endDate, String status) {
        if (endDate.compareTo(starDate) < 0) // Validate endDate is not previous to starDate
            return null;
        status = status.toLowerCase();
        return reservationRepository.getAllByDatesAndStatus(starDate, endDate, status);
    }

    /**
     *
     * @param reservationId
     * @return
     */
    public Optional<Reservation> getReservationById(Integer reservationId) {
        if (reservationId < 0)
            return null;
        return reservationRepository.getById(reservationId);
    }

    public Reservation insertReservation(Reservation reservation) {

    }

    public Reservation updateReservation(Reservation reservation) {

    }

    /**
     *
     * @param reservationId
     * @return
     */
    public boolean deleteReservation(Integer reservationId) {
        Boolean success = getReservationById(reservationId).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return success;
    }
}
