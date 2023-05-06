package com.sergioarboleda.ren_car.repositories;

import com.sergioarboleda.ren_car.models.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.swing.*;
import java.util.List;

public interface ReservationCRUDRepository extends CrudRepository<Reservation, Integer> {
    @Query(value = "SELECT * FROM reservations WHERE start_date >= ? AND end_date <= ? AND status = ?", nativeQuery = true)
    public List<Reservation> findReservationsByDatesAndState(String s_date, String e_date, String status);

}
