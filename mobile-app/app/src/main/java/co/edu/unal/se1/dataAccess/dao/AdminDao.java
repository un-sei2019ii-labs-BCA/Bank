package co.edu.unal.se1.dataAccess.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

import co.edu.unal.se1.dataAccess.model.Client;
import co.edu.unal.se1.dataAccess.model.Admin;

@Dao
public interface AdminDao {

    @Query("SELECT * FROM client")
    List<Client> getAllClients();

    @Query("SELECT * FROM client WHERE id = :id")
    Client getClientById(int id);

    @Insert
    void createClient(Client client);

    @Update
    void updateClient(Client client);

    @Delete
    void deleteClient(Client client);
}
