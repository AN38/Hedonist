package com.example.hedonist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ThankyouPage extends AppCompatActivity {

    TextView showTotalSum;

    TextView showOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thankyou_page);

//        String order = getIntent().getExtras("ORDER");
//        showOrder = findViewById(R.id.tv_order);
//        showOrder.setText(String.format(getString(R.string.your_order), order));

        int totalSum = getIntent().getIntExtra("TOTAL_SUM", 0);
        showTotalSum = findViewById(R.id.tv_show_sum);
        showTotalSum.setText(String.format(getString(R.string.total_sum), totalSum));
    }
}
