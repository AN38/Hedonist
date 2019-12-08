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
    private String login = "nikolskaya.a@chocolife.kz";
    private int invalid_email_error = R.string.invalid_email;


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
                    Intent intent = new Intent(LoginActivity.this, LoginActivityPassword.class);
                    intent.putExtra("User Email", editText);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this,invalid_email_error,Toast.LENGTH_LONG).show();
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

