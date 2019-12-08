package com.example.hedonist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivityPassword extends AppCompatActivity {

    private Button buttonLogIn;
    String warningText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_password);
        buttonLogIn = findViewById(R.id.btn_log_in);
        if(savedInstanceState != null) {
            String editText = savedInstanceState.getString("UserEmail");
            Toast.makeText(LoginActivityPassword.this, warningText, Toast.LENGTH_LONG).show();
        }
        buttonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivityPassword.this, MenuScreen.class);
                startActivity(intent);
            }
        });
    }
}
