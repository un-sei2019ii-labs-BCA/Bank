package co.edu.unal.se1.dataAccess.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.io.Serializable;

@Entity
public class Client extends User implements Serializable {

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "lastName")
    public String lastName;

    @ColumnInfo(name = "email")
    public String email;

    @ColumnInfo(name = "password")
    public int password;

    @ColumnInfo(name = "balance")
    public int balance;

    public int getBalance() {
        return balance;
    }
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}

