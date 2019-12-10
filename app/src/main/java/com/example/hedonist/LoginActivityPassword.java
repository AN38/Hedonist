package com.example.hedonist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.hedonist.LoginActivity.LOGIN_KEY;

public class LoginActivityPassword extends AppCompatActivity {

    private final String password = "qwerty123";

    private Button buttonLogIn;
    private EditText editTextPassword;
    private TextView userlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_password);
        userlogin = findViewById(R.id.user_login);
        buttonLogIn = findViewById(R.id.btn_log_in);
        editTextPassword = findViewById(R.id.et_password);
        String login = getIntent().getStringExtra(LOGIN_KEY);
        userlogin.setText(login);


        buttonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editText = editTextPassword.getText().toString();
                if (editText.equals(password)) {
                    Intent intent = new Intent(LoginActivityPassword.this, MenuScreen.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivityPassword.this, R.string.invalid_password, Toast.LENGTH_LONG).show();
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
