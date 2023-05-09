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

    /**
     *
     * @param reservation
     * @return
     */
    public Reservation insertReservation(Reservation reservation) {
        if ( (reservation.getCarFK() != null) && (reservation.getClientFK() != null) ) {
           if( (reservation.getStarDate() != null) && (reservation.getEndDate() != null) &&
                   (reservation.getEndDate().compareTo(reservation.getStarDate()) < 0))
               if ( (reservation.getStatus() != null) != (reservation.getCost() != null)) {
                   reservation.setStatus(reservation.getStatus().toLowerCase() );
                   return reservationRepository.save(reservation);
               }
               else
                   return reservation;
           else
               return reservation;
        }
        else
            return reservation;
    }

    /**
     *
     * @param reservation
     * @return
     */
    public Reservation updateReservation(Reservation reservation) {
        if ( reservation.getIdReservation() != null) {
            Optional<Reservation> temp = reservationRepository.getById(reservation.getIdReservation());
            if (temp.isPresent()){
                if (reservation.getStatus() != null)
                    temp.get().setStatus(reservation.getStatus().toLowerCase());
                if (reservation.getCost() != null)
                    temp.get().setCost(reservation.getCost());
                if (reservation.getGrade() != null)
                    temp.get().setGrade(reservation.getGrade());
                if (reservation.getComment() != null)
                    temp.get().setComment(reservation.getComment());
                if (reservation.getEndDate() != null) {
                    if (reservation.getEndDate().compareTo(temp.get().getStarDate()) > 0)
                        temp.get().setEndDate(reservation.getEndDate());
                }
                return reservationRepository.save(temp.get());
            }
            else
                return reservation;
        }
        else
            return reservation;
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
