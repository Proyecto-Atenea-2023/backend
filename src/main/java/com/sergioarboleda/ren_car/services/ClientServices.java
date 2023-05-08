package com.sergioarboleda.ren_car.services;

import com.sergioarboleda.ren_car.models.Client;
import com.sergioarboleda.ren_car.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.BackgroundPreinitializer;

import java.util.List;
import java.util.Optional;

public class ClientServices {
    @Autowired
    private ClientRepository clientRepository;

    /**
     *
     * @return
     */
    public List<Client> getAllClients() {
        return clientRepository.getAll();
    }

    /**
     *
     * @param clientId
     * @return
     */
    public Optional<Client> getClientById(Integer clientId) {
        if(clientId < 0) // There is no negative IDs
            return null;
        return clientRepository.getById(clientId);
    }

    /**
     *
     * @param email
     * @return
     */
    public Optional<Client> getClientByEmail(String email) {
        //TODO validate regex: [a-z0-9]^*@domain.com

        return clientRepository.getByEmail(email);
    }

    /**
     *
     * @param nickname
     * @return
     */
    public Optional<Client> getClientByNickname(String nickname) {
        if (nickname.length() < 4) // nickname must have minimum four characters
            return null;
        return clientRepository.getByNickname(nickname);
    }

    public Client insertClient(Client client) {

    }

    public Client updateClient(Client client) {

    }

    /**
     *
     * @param clientId
     * @return
     */
    public boolean deleteClient(Integer clientId) {
        Boolean success = getClientById(clientId).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return success;
    }
}
