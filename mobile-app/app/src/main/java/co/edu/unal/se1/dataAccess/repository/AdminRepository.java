package co.edu.unal.se1.dataAccess.repository;

import android.content.Context;
import androidx.room.Room;
import java.util.List;

import co.edu.unal.se1.dataAccess.db.Database;
import co.edu.unal.se1.dataAccess.model.Admin;
import co.edu.unal.se1.dataAccess.model.Client;

public class AdminRepository {

    private String DB_NAME = "se1_db_bank";
    private Database database;

    public AdminRepository(Context context) {
        database = Room.databaseBuilder(context, Database.class, DB_NAME).
                allowMainThreadQueries().build();
    }

    public List<Client> getAllClient() {
        return database.adminDao().getAllClients();
    }

    public Client getClientById(int id) {
        return database.adminDao().getClientById(id);
    }

    public void createClient(final Client client) {
        database.adminDao().createClient(client);
    }

    public void updateClient(Client client) {
        database.adminDao().updateClient(client);
    }

    public void deleteClient(int id) {
        Client client = database.adminDao().getClientById(id);
        database.adminDao().deleteClient(client);
    }
}
