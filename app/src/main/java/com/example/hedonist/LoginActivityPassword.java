package com.example.hedonist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivityPassword extends AppCompatActivity {

    private Button buttonLogIn;
    private EditText editTextPassword;
    private String password = "qwerty123";
    private int invalid_password_error = R.string.invalid_password;
    private TextView userlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_password);
        userlogin = findViewById(R.id.user_login);
        buttonLogIn = findViewById(R.id.btn_log_in);
        editTextPassword = findViewById(R.id.et_password);
        String login = getIntent().getStringExtra("User Email");
        userlogin.setText(login);


        buttonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editText = editTextPassword.getText().toString();
                if (editText.equals(password)) {
                    Intent intent = new Intent(LoginActivityPassword.this, MenuScreen.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivityPassword.this, invalid_password_error, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        String userEmail = editTextEmail.getText().toString();
//        outState.putString("UserEmail", userEmail);
//
//    }
}
