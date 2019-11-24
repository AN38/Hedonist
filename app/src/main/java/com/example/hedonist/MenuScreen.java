package com.example.hedonist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MenuScreen extends AppCompatActivity {

    int totalSum;
    TextView showSum;
    RadioButton radioButtonCoffee;
    RadioButton radioButtonTea;
    RadioButton radioButtonMilkshake;
    CheckBox checkBoxCinnamon;
    CheckBox checkBoxMilk;
    CheckBox checkBoxSugar;
    CheckBox checkBoxMarshmallow;
    CheckBox checkBoxLemon;
    Button buttonOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioButtonCoffee = findViewById(R.id.radio_btn_coffee);
        radioButtonTea = findViewById(R.id.radio_btn_tea);
        radioButtonMilkshake = findViewById(R.id.radio_btn_milkshake);
        checkBoxCinnamon = findViewById(R.id.checkbox_cinnamon);
        checkBoxMilk = findViewById(R.id.checkbox_milk);
        checkBoxSugar = findViewById(R.id.checkbox_sugar);
        checkBoxMarshmallow = findViewById(R.id.checkbox_marshmallow);
        checkBoxLemon = findViewById(R.id.checkbox_lemon);
        buttonOrder = findViewById(R.id.btn_order);
        RadioGroup radioGroup = findViewById(R.id.radio_btn_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int id) {
                showSum = findViewById(R.id.tv_total_sum);
                switch(id) {
                    case R.id.radio_btn_coffee:
                        totalSum += 550;
                        showSum.setText("Total sum: "+String.valueOf(totalSum));
                        break;
                    case R.id.radio_btn_tea:
                        totalSum += 450;
                        showSum.setText("Total sum: "+String.valueOf(totalSum));
                        break;
                    case R.id.radio_btn_milkshake:
                        totalSum += 650;
                        showSum.setText("Total sum: "+String.valueOf(totalSum));
                        break;
                    default:
                        break;
                }
            }});
        checkBoxCinnamon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View checkBoxCinnamon) {
                Log.i("Click radio", "clik checkBoxCinnamon");
                totalSum +=50;
                showSum.setText("Total sum: "+String.valueOf(totalSum));
            }
        });
        checkBoxMilk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View checkBoxMilk) {
                Log.i("Click radio", "clik checkBoxMilk");
                totalSum +=50;
                showSum.setText("Total sum: "+String.valueOf(totalSum));
            }
        });
        checkBoxMarshmallow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View checkBoxMarshmallow) {
                Log.i("Click radio", "clik checkBoxMarshmallow");
                totalSum +=100;
                showSum.setText("Total sum: "+String.valueOf(totalSum));
            }
        });
        checkBoxLemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View checkBoxCinnamon) {
                Log.i("Click radio", "clik checkBoxLemon");
                totalSum +=50;
                showSum.setText("Total sum: "+String.valueOf(totalSum));
            }
        });
        buttonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Click radio", String.valueOf(totalSum));
                Intent intent = new Intent(MenuScreen.this, ThankyouPage.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("UserSum", String.valueOf(totalSum));
    }

}
