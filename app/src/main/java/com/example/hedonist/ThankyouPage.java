package com.example.hedonist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ThankyouPage extends AppCompatActivity {

    TextView showTotalSum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thankyou_page);
        if(savedInstanceState != null) {
            showTotalSum = findViewById(R.id.tv_show_sum);
            String total = savedInstanceState.getString("UserSum");
            showTotalSum.setText("Total sum: "+total);
        }

    }
}
