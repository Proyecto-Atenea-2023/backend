package com.sergioarboleda.ren_car.repositories;

import com.sergioarboleda.ren_car.models.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientCRUDRepository extends CrudRepository<Client, Integer> {
    Optional<Client> findByNickname(String nickname);
    Optional<Client> findByEmail(String email);
}
