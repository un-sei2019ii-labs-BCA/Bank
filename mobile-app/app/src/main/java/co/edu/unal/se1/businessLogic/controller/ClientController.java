package co.edu.unal.se1.businessLogic.controller;

import android.content.Context;

import co.edu.unal.se1.dataAccess.model.Admin;
import co.edu.unal.se1.dataAccess.model.Client;
import co.edu.unal.se1.dataAccess.repository.AdminRepository;
import co.edu.unal.se1.dataAccess.repository.ClientRepository;


public class ClientController {

    private ClientRepository clientRepository;

    public ClientController() {

    }


    public boolean sendMoney(int sourceId, int targetId, int value, Context context) {

        clientRepository = new ClientRepository(context);

        final Client sourceClient = clientRepository.getClientById(sourceId);
        System.out.println("Source Client - ID: " + sourceClient.getId() +
                ", Name: " + sourceClient.getName() +
                ", Balance: " + sourceClient.getBalance());

        if (sourceClient.getBalance() >= value) {

            final Client targetClient = clientRepository.getClientById(targetId);
            System.out.println("Target User - ID: " + targetClient.getId() +
                    ", Name: " + targetClient.getName() +
                    ", Balance: " + targetClient.getBalance());

            sourceClient.setBalance(sourceClient.getBalance() - value);
            targetClient.setBalance(targetClient.getBalance() + value);
            clientRepository.updateClient(sourceClient);
            clientRepository.updateClient(targetClient);

            final Client updatedSourceClient = clientRepository.getClientById(sourceId);
            System.out.println("Source Client (updated) - ID: " + updatedSourceClient.getId() +
                    ", Name: " + updatedSourceClient.getName() +
                    ", Balance: " + updatedSourceClient.getBalance());

            final Client updatedTargetClient = clientRepository.getClientById(targetId);
            System.out.println("Target Client (updated) - ID: " + updatedTargetClient.getId() +
                    ", Name: " + updatedTargetClient.getName() +
                    ", Balance: " + updatedTargetClient.getBalance());

            return true;

        } else {

            return false;
        }

    }
}
