package com.example.hedonist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class LoginActivity extends AppCompatActivity {

    private final String LOGIN = "nikolskaya.a@chocolife.kz";
    public static final String LOGIN_KEY = "UserEmail";

    private int invalid_email_error = R.string.invalid_email;

    private Button buttonContinue;
    private ImageView marshmallowIcon;
    private ImageView coffeeIcon;
    private ImageView cupcakeIcon;
    private LinearLayout login_activity_layout;
    private EditText editTextEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        coffeeIcon = findViewById(R.id.coffee_icon);
        marshmallowIcon = findViewById(R.id.marshmallow_icon);
        cupcakeIcon = findViewById(R.id.cupcake_icon);
        buttonContinue = findViewById(R.id.btn_continue);
        editTextEmail = findViewById(R.id.et_email);
        login_activity_layout = findViewById(R.id.login_activity_layout);

        coffeeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login_activity_layout.setBackground(ContextCompat.getDrawable(coffeeIcon.getContext(), R.drawable.gradient_orange_violet));
            }
        });

        marshmallowIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login_activity_layout.setBackground(ContextCompat.getDrawable(coffeeIcon.getContext(), R.drawable.gradient_purple_blue));
            }
        });

        cupcakeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login_activity_layout.setBackground(ContextCompat.getDrawable(coffeeIcon.getContext(), R.drawable.gradient_orange_violet));
            }
        });


        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editText = editTextEmail.getText().toString();
                if (editText.equals(LOGIN)) {
                    Intent intent = new Intent(LoginActivity.this, LoginActivityPassword.class);
                    intent.putExtra(LOGIN_KEY, editText);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, invalid_email_error, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String userEmail = editTextEmail.getText().toString();
        outState.putString(LOGIN_KEY, userEmail);
    }
}

