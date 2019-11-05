package co.edu.unal.se1.businessLogic.controller;

import android.content.Context;

import co.edu.unal.se1.dataAccess.model.Admin;
import co.edu.unal.se1.dataAccess.model.Client;
import co.edu.unal.se1.dataAccess.repository.AdminRepository;
import co.edu.unal.se1.dataAccess.repository.ClientRepository;


public class AdminController {

    private AdminRepository adminRepository;

    public AdminController() {

    }

    public void createUser(Client client, Context context) {

        adminRepository = new AdminRepository(context);
        adminRepository.createClient(client);
        System.out.println("¡Usuario creado satisfactoriamente!");
    }
    public boolean chargueMoney(int sourceId,int value,Context context){

        adminRepository = new AdminRepository(context);

        final Client sourceClient = adminRepository.getClientById(sourceId);
        System.out.println("Source User - ID: " + sourceClient.getId() +
                ", Name: " + sourceClient.getName() +
                ", Balance: " + sourceClient.getBalance());

        sourceClient.setBalance(sourceClient.getBalance() + value);
        adminRepository.updateClient(sourceClient);

        final Client updatedSourceClient = adminRepository.getClientById(sourceId);
        System.out.println("Source Client (updated) - ID: " + updatedSourceClient.getId() +
                ", Name: " + updatedSourceClient.getName() +
                ", Balance: " + updatedSourceClient.getBalance());

        return true;
    }
    public boolean sendMoney(int sourceId, int targetId, int value, Context context) {

        adminRepository = new AdminRepository(context);

        final Client sourceClient = adminRepository.getClientById(sourceId);
        System.out.println("Source Client - ID: " + sourceClient.getId() +
                ", Name: " + sourceClient.getName() +
                ", Balance: " + sourceClient.getBalance());

        if (sourceClient.getBalance() >= value) {

            final Client targetClient = adminRepository.getClientById(targetId);
            System.out.println("Target User - ID: " + targetClient.getId() +
                    ", Name: " + targetClient.getName() +
                    ", Balance: " + targetClient.getBalance());

            sourceClient.setBalance(sourceClient.getBalance() - value);
            targetClient.setBalance(targetClient.getBalance() + value);
            adminRepository.updateClient(sourceClient);
            adminRepository.updateClient(targetClient);

            final Client updatedSourceClient = adminRepository.getClientById(sourceId);
            System.out.println("Source Client (updated) - ID: " + updatedSourceClient.getId() +
                    ", Name: " + updatedSourceClient.getName() +
                    ", Balance: " + updatedSourceClient.getBalance());

            final Client updatedTargetClient = adminRepository.getClientById(targetId);
            System.out.println("Target Client (updated) - ID: " + updatedTargetClient.getId() +
                    ", Name: " + updatedTargetClient.getName() +
                    ", Balance: " + updatedTargetClient.getBalance());

            return true;

        } else {

            return false;
        }

    }
}
