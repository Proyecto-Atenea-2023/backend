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

    /**
     *
     * @param client
     * @return
     */
    public Client insertClient(Client client) {
        if (client.getIdClient() != null) {
            Optional<Client> temp_id = clientRepository.getById(client.getIdClient());
            if (temp_id.isPresent())
                return client; // There is a client in the database with the same id
            if (client.getEmail() != null) {
                //TODO validate regex: [a-z0-9]^*@domain.com
                Optional<Client> temp_email = clientRepository.getByEmail(client.getEmail());
                if (temp_email.isPresent())
                    return client; // There is a client in the database with the same email
            }
            if (client.getNickname() != null) {
                Optional<Client> temp_nickname = clientRepository.getByNickname(client.getNickname());
                if (temp_nickname.isPresent())
                    return client; // There is in th database with the same nickname
            }
            if ( (client.getName() != null) && (client.getLastnames() != null) &&
                    (client.getAddress() != null) && (client.getPhones() != null) &&
                    (client.getPassword() != null) ) {
                return clientRepository.save(client);
            }
            else
                return client;
        }
        else
            return client;
    }

    /**
     *
     * @param client
     * @return
     */
    public Client updateClient(Client client) {
        if (client.getIdClient() != null){
            Optional<Client> temp_id = clientRepository.getById(client.getIdClient());
            if (temp_id.isPresent()){
                if (client.getName() != null)
                    temp_id.get().setName(client.getName());
                if (client.getLastnames() != null)
                    temp_id.get().setLastnames(client.getLastnames());
                if (client.getAddress() != null)
                    temp_id.get().setAddress(client.getAddress());
                if (client.getPhones() != null)
                    temp_id.get().setPhones(client.getPhones());
                if (client.getPassword() != null)
                    temp_id.get().setPassword(client.getPassword());
                if (client.getEmail() != null) {
                    Optional<Client> temp_email = clientRepository.getByEmail(client.getEmail());
                    return client; // There is a client in the database with the same email
                }
                return clientRepository.save(temp_id.get());
            }
            else
                return client;
        }
        else
            return client;
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
