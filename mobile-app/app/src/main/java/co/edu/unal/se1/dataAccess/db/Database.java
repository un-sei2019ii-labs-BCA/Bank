package co.edu.unal.se1.dataAccess.db;

import androidx.room.RoomDatabase;

import co.edu.unal.se1.dataAccess.dao.ClientDao;
import co.edu.unal.se1.dataAccess.model.Client;
import co.edu.unal.se1.dataAccess.dao.AdminDao;
import co.edu.unal.se1.dataAccess.model.Admin;


@androidx.room.Database(entities = {Client.class, Admin.class}, version = 1)
public abstract class Database extends RoomDatabase {

    public abstract ClientDao clientDao();
    public abstract AdminDao adminDao();
}
