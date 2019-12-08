package com.example.hedonist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Button buttonContinue;
    private EditText editTextEmail;
    private String login = "nikolskaya.a@rahmetapp.kz";
    private int error = R.string.invalid_email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        buttonContinue = findViewById(R.id.btn_continue);
        editTextEmail = findViewById(R.id.et_email);

        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editText = editTextEmail.getText().toString();
                if (editText.equals(login)) {
                    Toast.makeText(LoginActivity.this,editText,Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity.this, LoginActivityPassword.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this,error,Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String userEmail = editTextEmail.getText().toString();
        outState.putString("UserEmail", userEmail);

    }
}

