package co.edu.unal.se1.dataAccess.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Transaction implements Serializable {

    @PrimaryKey
    public int id;

    @ForeignKey(entity = User.class,
            parentColumns   = "id",
            childColumns = "userId")
    public User depositor;

    @ForeignKey(entity = User.class,
            parentColumns = "id",
            childColumns = "userId")
    public User receiver;

    @ColumnInfo(name = "amount")
    public int amount;

    @ColumnInfo(name = "date")
    public int date;

    public int getId() {
        return id;
    }

    public User getDepositor() {
        return depositor;
    }

    public User getReceiver() {
        return receiver;
    }

    public int getAmount() {
        return amount;
    }

    public int getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDepositor(User depositor) {
        this.depositor = depositor;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setDate(int date) {
        this.date = date;
    }
}

