package co.edu.unal.se1.dataAccess.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import co.edu.unal.se1.dataAccess.model.Transaction;
import co.edu.unal.se1.dataAccess.model.Client;

@Dao
public interface ClientDao {

    @Query("SELECT * FROM client WHERE id = :id")
    Client getClientById(int id);

    @Query("SELECT * FROM client")
    List<Transaction> getAllTransactions();

    @Query("SELECT id, username, name,lastName,balance FROM client where id = :id")
    String getClientInfo(int id);

    @Query("UPDATE client SET password = :password WHERE id = :id")
    void updatePasword(String password, int id);

    @Delete
    void deleteClient(Client client);

    @Update
    void updateClient(Client client);
}
