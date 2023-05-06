package com.sergioarboleda.ren_car.repositories;

import com.sergioarboleda.ren_car.models.Client;

import java.util.Optional;

public interface ClientCRUDRepository extends CarCRUDRepository<Client, Integer>{
    public Optional<Client> findByNickname(String nickname);
    public  Optional<Client> findByEmail(String email);
}
