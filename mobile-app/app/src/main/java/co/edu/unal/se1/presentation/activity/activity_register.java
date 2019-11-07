package co.edu.unal.se1.presentation.activity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import co.edu.unal.se1.R;
import co.edu.unal.se1.dataAccess.model.Client;
import co.edu.unal.se1.dataAccess.model.User;
import co.edu.unal.se1.businessLogic.controller.*;


public class activity_register extends AppCompatActivity {
    private AdminController adminController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final TextInputEditText idInput = findViewById(R.id.id);
        final TextInputEditText nameInput = findViewById(R.id.name);
        final TextInputEditText balanceInput = findViewById(R.id.balance);

        Button createButton = findViewById(R.id.createButton);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Client user = new Client();
                user.setId(Integer.parseInt(idInput.getText().toString()));
                user.setName(nameInput.getText().toString());
                user.setBalance(Integer.parseInt(balanceInput.getText().toString()));

                adminController = new AdminController();
                adminController.createUser(user, getApplicationContext());
            }
        });

        final TextView sourceIdInput = findViewById(R.id.sourceId);
        final TextView targetIdInput = findViewById(R.id.targetId);
        final TextView valueInput = findViewById(R.id.value);

        Button sendMoneyButton = findViewById(R.id.sendMoneyButton);
        sendMoneyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                adminController = new AdminController();

                int sourceId = Integer.parseInt(sourceIdInput.getText().toString());
                int targetId = Integer.parseInt(targetIdInput.getText().toString());
                int value = Integer.parseInt(valueInput.getText().toString());

                boolean transaction = adminController.sendMoney(sourceId, targetId, value, getApplicationContext());

                if (transaction) {
                    System.out.println("¡Transacción satisfactoria!");
                } else {
                    System.out.println("¡Transacción no satisfactoria!");
                }
            }
        });
    }

}
