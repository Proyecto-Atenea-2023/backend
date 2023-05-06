package com.sergioarboleda.ren_car.repositories;

import com.sergioarboleda.ren_car.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {
    @Autowired
    private ClientCRUDRepository clientCRUDRepository;

    /**
     *
     * @return
     */

    public List<Client> getAll(){
        return (List<Client>) clientCRUDRepository.findAll();
    }

    /**
     *
     * @param clientId
     * @return
     */

   public Optional<Client> getById(Integer clientId) {
       return clientCRUDRepository.findById(clientId);
   }

    /**
     *
     * @param email
     * @return
     */

    public Optional<Client> getByEmail(String email) {
        return clientCRUDRepository.findByEmail(email);
    }

    /**
     *
     * @param nickname
     * @return
     */

    public Optional<Client> getByNickname(String nickname) {
    return  clientCRUDRepository.findByNickname(nickname);
    }

    /**
     *
     * @param client
     * @return
     */

    public Client save(Client client) {
        return clientCRUDRepository.save(client);
    }

    /**
     *
     * @param client
     */
    public void delete(Client client) {
        clientCRUDRepository.delete(client);
    }
}
