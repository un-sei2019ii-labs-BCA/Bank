package co.edu.unal.se1.dataAccess.repository;

import android.content.Context;
import androidx.room.Room;
import java.util.List;

import co.edu.unal.se1.dataAccess.db.Database;
import co.edu.unal.se1.dataAccess.model.Client;
import co.edu.unal.se1.dataAccess.model.Transaction;

public class ClientRepository {

    private String DB_NAME = "se1_db_bank";
    private Database database;

    public ClientRepository(Context context) {
        database = Room.databaseBuilder(context, Database.class, DB_NAME).
                allowMainThreadQueries().build();
    }

    public List<Transaction> getAllTransactions(){
        return database.clientDao().getAllTransactions();
    }
    public Client getClientById(int id) {
        return database.clientDao().getClientById(id);
    }
    public void updateClient(Client client) {

        database.clientDao().updateClient(client);
    }
    public String getClientInfo (int id) {

        return database.clientDao().getClientInfo(id);

    }

    public void updatePassword(String password, int id){
        database.clientDao().updatePasword(password, id);
    }

    public void deleteClient(int id) {
        Client client = database.clientDao().getClientById(id);
        database.clientDao().deleteClient(client);
    }
}

